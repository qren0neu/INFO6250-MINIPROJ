package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.manager.ServletManager;
import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class SumitEditInfo
 */
public class SumitEditInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumitEditInfo() {
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
        if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String userId = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean logout = false;
        boolean isSelf = userId.equals(SessionManager.getInstance().getUserId(request));
        if (isSelf && ((null != password && !password.isBlank())
                || !SessionManager.getInstance().getUserName(request).equals(username))) {
            // we are the user ourselves
            // we have changed password
            // or we have changed username
            logout = true;
        }
        boolean result = UserService.getInstance().updateUserInfo(request, response);

        if (result) {
            if (isSelf) {
                request.setAttribute("fname", request.getParameter("fname"));
            } else {
                String name = UserService.getInstance()
                        .getUserInfo(SessionManager.getInstance().getUserName(request))
                        .getUserBean().getFname();
                request.setAttribute("fname", name);
            }
            if (logout) {
                request.setAttribute("returnTo", "./");
            }
            request.getRequestDispatcher(Constants.PAGE_SUCCESS).forward(request, response);
            // if we change the user info successfully, we may want to logout directly
            if (logout) {
                SessionManager.getInstance().endSession(request);
            }
        } else {
            request.getRequestDispatcher(Constants.PAGE_FAILED).forward(request, response);
        }
    }

}
