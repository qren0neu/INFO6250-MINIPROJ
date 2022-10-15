package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.qiren.miniproj.bean.UserBean;
import com.qiren.miniproj.manager.ServletManager;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class ViewUserList
 */
public class ViewUserList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserList() {
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
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }

        List<UserBean> userList = UserService.getInstance().getAllUser();
        request.setAttribute(Constants.PARAM_USER_LIST, userList);
        request.getRequestDispatcher(Constants.PAGE_USER_LIST).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
