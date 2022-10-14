package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.service.BorrowBookService;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class BorrowBook
 */
public class BorrowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	    String error = BorrowBookService.getInstance().borrowBook(request, response);
	    if (null != error) {
            request.setAttribute(Constants.PARAM_ERROR, error);
            request.getRequestDispatcher(Constants.PAGE_FAILED).forward(request, response);
	    } else {
            String name = UserService.getInstance()
                    .getUserInfo(SessionManager.getInstance().getUserName(request))
                    .getUserBean().getFname();
            request.setAttribute("fname", name);
            request.getRequestDispatcher(Constants.PAGE_SUCCESS).forward(request, response);
	    }
	}

}
