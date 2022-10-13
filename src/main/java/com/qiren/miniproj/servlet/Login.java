package com.qiren.miniproj.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.bean.UserBean;
import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionManager.getInstance().hasSession(request)) {
		    // if logged in, go to dashboard
            response.sendRedirect("controller?action=dashboard");
		} else {
		    // if not logged in, go to login
		    request.getRequestDispatcher(Constants.PAGE_LOGIN).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	    String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserBean userbean = UserService.getInstance().getUserInfo(username, password);
        if (null != userbean) {
            // we have that user
            SessionManager.getInstance().beginSession(
                    request, username, 
                    userbean.getUserBean().getFname(), userbean.getUserBean().getRole());

            response.sendRedirect("controller?action=dashboard");
        } else {
            request.setAttribute("error", "User " + username + " does not exist");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
            rd.forward(request, response);
        }
	}

}
