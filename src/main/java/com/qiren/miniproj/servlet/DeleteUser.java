package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.manager.ServletManager;
import com.qiren.miniproj.service.BookService;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String confirm = request.getParameter("confirm");
        String userId = request.getParameter("userid");
        if (null != confirm) {
            // delete
            UserService.getInstance().deleteUser(userId);
            response.sendRedirect("controller?action=dashboard");
        } else {
            // warning
            request.setAttribute("value", userId);
            request.setAttribute("key", "userid");
            request.setAttribute("action", Constants.ACTION_DELETE_USER);
            request.setAttribute("warn", "It is not revertable to delete a user");
            request.getRequestDispatcher(Constants.PAGE_WARNING).forward(request, response);
        }
	}

}
