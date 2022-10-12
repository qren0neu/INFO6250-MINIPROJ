package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Mapping of Users:
     * from action to the Servlet
     * actions out of this map will return 404
     */
    private Map<String, String> roleMapUser = new HashMap<String, String>();

    /**
     * Mapping of Admin:
     * from action to the Servlet
     * actions out of this map will return 404
     */
    private Map<String, String> roleMapAdmin = new HashMap<String, String>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();

    }

    private void initRoleMap() {

        roleMapUser.put(Constants.ACTION_REGISTER, Constants.HASH_REGISTER);
        roleMapUser.put(Constants.ACTION_LOGIN, Constants.HASH_LOGIN);
        roleMapUser.put(Constants.ACTION_DASHBOARD, Constants.HASH_DASHBOARD_USER);
        roleMapUser.put(Constants.ACTION_BOOKS, Constants.HASH_BOOKS_USER);
        roleMapUser.put(Constants.ACTION_BOOK_ORDER, Constants.HASH_ORDERS_USER);
        roleMapUser.put(Constants.ACTION_VIEW_USER, Constants.HASH_VIEW_USER);

        roleMapAdmin.put(Constants.ACTION_LOGIN, Constants.HASH_LOGIN);
        roleMapAdmin.put(Constants.ACTION_DASHBOARD, Constants.HASH_DASHBOARD_ADMIN);
        roleMapAdmin.put(Constants.ACTION_BOOKS, Constants.HASH_BOOKS_ADMIN);
        roleMapAdmin.put(Constants.ACTION_BOOK_ORDER, Constants.HASH_ORDERS_ADMIN);
        roleMapAdmin.put(Constants.ACTION_USER_LIST, Constants.HASH_VIEW_USER_LIST);
        roleMapAdmin.put(Constants.ACTION_VIEW_USER, Constants.HASH_VIEW_USER_ADMIN);

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        intercept(request, response, Constants.METHOD_GET);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        intercept(request, response, Constants.METHOD_POST);
    }

    private void intercept(HttpServletRequest request, HttpServletResponse response, String method) {
        if (!SessionManager.getInstance().hasSession(request)) {
            turnToLogin(request, response);
            return;
        }
        String role = SessionManager.getInstance().getRole(request);

        if (null != role && !role.isBlank()) {
            if (Constants.METHOD_POST.equals(method)) {
                interceptPostMethod(request, response, role);
            } else if (Constants.METHOD_GET.equals(method)) {
                interceptGetMethod(request, response, role);
            } else {
                turnToError(request, response);
            }
        } else {
            turnToError(request, response);
        }
    }

    private void interceptGetMethod(HttpServletRequest request,
            HttpServletResponse response, String role) {
        String action = request.getParameter("action");
        String target = "";
        if (Constants.ROLE_USER.equals(role)) {
            target = roleMapUser.get(action);
        } else {
            target = roleMapUser.get(action);
        }
        if (null != target && !target.isBlank()) {
            try {
                request.getRequestDispatcher(target).forward(request, response);
            } catch (ServletException | IOException e) {
                turnToError(request, response);
                e.printStackTrace();
            }
        } else {
            turnToError(request, response);
        }
    }

    private void interceptPostMethod(HttpServletRequest request,
            HttpServletResponse response, String role) {
        String action = request.getParameter("action");
        String target = "";
        if (Constants.ROLE_USER.equals(role)) {
            target = roleMapAdmin.get(action);
        } else {
            target = roleMapAdmin.get(action);
        }
        if (null != target && !target.isBlank()) {
            try {
                request.getRequestDispatcher(target).forward(request, response);
            } catch (ServletException | IOException e) {
                turnToError(request, response);
                e.printStackTrace();
            }
        } else {
            turnToError(request, response);
        }
    }

    /**
     * If page not found
     */
    private void turnToError(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("dashboard");
        } catch (IOException e) {
            try {
                response.getWriter().print("<p>Error Page Not Found!</p>");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Go to login page
     */
    private void turnToLogin(HttpServletRequest request, HttpServletResponse response) {
        // go to login page if not logged in
        String loginPage = Constants.HASH_LOGIN;
        try {
            request.getRequestDispatcher(loginPage).forward(request, response);
        } catch (ServletException e) {
            turnToError(request, response);
            e.printStackTrace();
        } catch (IOException e) {
            turnToError(request, response);
            e.printStackTrace();
        }
    }
}
