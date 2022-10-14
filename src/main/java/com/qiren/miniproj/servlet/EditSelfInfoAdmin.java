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
 * Servlet implementation class EditSelfInfoAdmin
 */
public class EditSelfInfoAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSelfInfoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // if we have username sent by request, we use that instead of our own.
        if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }
        String userName = request.getParameter(Constants.PARAM_USER_NAME);
        if (null == userName || userName.isBlank()) {
            userName = SessionManager.getInstance().getUserName(request);
        }
        if (null != userName) {
            UserBean userBean = UserService.getInstance().getUserInfo(userName);
            request.setAttribute(Constants.PARAM_USER_BEAN, userBean);
            request.getRequestDispatcher(Constants.PAGE_EDIT_USER).forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        boolean result = UserService.getInstance().submitUserInfo(request, response);
        if (result) {
            request.getRequestDispatcher(Constants.PAGE_SUCCESS).forward(request, response);
        } else {
            request.getRequestDispatcher(Constants.PAGE_FAILED).forward(request, response);
        }
    }

}
