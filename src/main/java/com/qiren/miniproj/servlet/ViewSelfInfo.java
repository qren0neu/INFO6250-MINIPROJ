package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.bean.UserBean;
import com.qiren.miniproj.manager.ServletManager;
import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class ViewSelfInfo
 */
public class ViewSelfInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSelfInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // jump to the view info page
        if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }
        String userName = SessionManager.getInstance().getUserName(request);
	    if (null != userName) {
	        UserBean userBean = UserService.getInstance().getUserInfo(userName);
	        request.setAttribute(Constants.PARAM_USER_BEAN, userBean);
	        request.getRequestDispatcher(Constants.PAGE_VIEW_USER).forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // we have nothing to do with post here
		doGet(request, response);
	}

}
