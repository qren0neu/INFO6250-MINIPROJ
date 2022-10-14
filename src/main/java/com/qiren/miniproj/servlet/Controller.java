package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.qiren.miniproj.manager.ServletManager;
import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.service.UserService;
import com.qiren.miniproj.tools.Constants;
import com.qiren.miniproj.tools.Utils;

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

    private Map<String, String> roleMapCommon = new HashMap<String, String>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        initRoleMap();
    }

    private void initRoleMap() {
        roleMapCommon.put(Constants.ACTION_LOGIN, Constants.HASH_LOGIN);
        roleMapCommon.put(Constants.ACTION_REGISTER, Constants.HASH_REGISTER);
        roleMapCommon.put(Constants.ACTION_LOGOUT, Constants.HASH_LOGOUT);

        roleMapUser.put(Constants.ACTION_DASHBOARD, Constants.HASH_DASHBOARD_USER);
        roleMapUser.put(Constants.ACTION_BOOKS, Constants.HASH_BOOKS_USER);
        roleMapUser.put(Constants.ACTION_BOOK_ORDER, Constants.HASH_ORDERS_USER);
        roleMapUser.put(Constants.ACTION_VIEW_USER, Constants.HASH_VIEW_USER);
        roleMapUser.put(Constants.ACTION_EDIT_USER, Constants.HASH_EDIT_USER);
        roleMapUser.put(Constants.ACTION_UPDATE_USER, Constants.HASH_UPDATE_USER);
        roleMapUser.put(Constants.ACTION_VIEW_BOOK, Constants.HASH_VIEW_BOOK);

        roleMapAdmin.put(Constants.ACTION_DASHBOARD, Constants.HASH_DASHBOARD_ADMIN);
        roleMapAdmin.put(Constants.ACTION_BOOKS, Constants.HASH_BOOKS_ADMIN);
        roleMapAdmin.put(Constants.ACTION_BOOK_ORDER, Constants.HASH_ORDERS_ADMIN);
        roleMapAdmin.put(Constants.ACTION_USER_LIST, Constants.HASH_VIEW_USER_LIST);
        roleMapAdmin.put(Constants.ACTION_VIEW_USER, Constants.HASH_VIEW_USER_ADMIN);
        roleMapAdmin.put(Constants.ACTION_EDIT_USER, Constants.HASH_EDIT_USER_ADMIN);
        roleMapAdmin.put(Constants.ACTION_UPDATE_USER, Constants.HASH_UPDATE_USER);
        roleMapAdmin.put(Constants.ACTION_VIEW_BOOK, Constants.HASH_VIEW_BOOK_ADMIN);
        roleMapAdmin.put(Constants.ACTION_ADD_BOOK, Constants.HASH_ADD_BOOK);
        roleMapAdmin.put(Constants.ACTION_UPDATE_BOOK, Constants.HASH_UPDATE_BOOK);
        roleMapAdmin.put(Constants.ACTION_EDIT_BOOKS, Constants.HASH_EDIT_BOOKS);
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

        String action = request.getParameter(Constants.PARAM_ACTION);
        Utils.log("Intercept: " + action + " " + method);
        if (action == null || action.isBlank()) {
            turnToError(request, response);
        }
        String commonHashIfExist = roleMapCommon.get(action);
        if (null != commonHashIfExist) {
            Utils.log("Intercept Common: " + action + " " + method + " " + commonHashIfExist);
            interceptCommon(request, response, commonHashIfExist, method);
            return;
        }
        if (!SessionManager.getInstance().hasSession(request)) {
            Utils.log("Turn to login: " + action + " " + method);
            turnToLogin(request, response);
            return;
        }
        if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }
        String role = SessionManager.getInstance().getRole(request);
        Utils.log("Intercept get role: " + role);
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

    private void interceptCommon(HttpServletRequest request,
            HttpServletResponse response, String hash, String method) {
        try {
            if (Constants.METHOD_GET.equals(method)) {
                response.sendRedirect(hash);
            } else {
                request.getRequestDispatcher(hash).forward(request, response);
            }
        } catch (IOException | ServletException e) {
            turnToError(request, response);
            e.printStackTrace();
        }
    }

    private void interceptGetMethod(HttpServletRequest request,
            HttpServletResponse response, String role) {
        String action = request.getParameter(Constants.PARAM_ACTION);
        String target = "";
        if (Constants.ROLE_USER.equals(role)) {
            target = roleMapUser.get(action);
        } else {
            target = roleMapAdmin.get(action);
        }
        Utils.log("Intercept Get: " + action + " " + target + " " + role);
        if (null != target && !target.isBlank()) {
            try {
                // request.getRequestDispatcher(target).forward(request, response);
                response.sendRedirect(target);
            } catch (IOException e) {
                turnToError(request, response);
                e.printStackTrace();
            }
        } else {
            turnToError(request, response);
        }
    }

    private void interceptPostMethod(HttpServletRequest request,
            HttpServletResponse response, String role) {
        String action = request.getParameter(Constants.PARAM_ACTION);
        String target = "";
        if (Constants.ROLE_USER.equals(role)) {
            target = roleMapUser.get(action);
        } else {
            target = roleMapAdmin.get(action);
        }
        Utils.log("Intercept Post: " + action + " " + target + " " + role);
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
            // request.getRequestDispatcher(loginPage).forward(request, response);
            response.sendRedirect(loginPage);
        } catch (IOException e) {
            turnToError(request, response);
            e.printStackTrace();
        }
    }
}
