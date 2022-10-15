package com.qiren.miniproj.manager;

import com.qiren.miniproj.bean.SessionBean;
import com.qiren.miniproj.tools.Constants;
import com.qiren.miniproj.tools.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionManager {

    private static final String SESSION_KEY = "SESSION_KEY";

    private SessionManager() {

    }

    /**
     * Check if the users are currently in their session.
     */
    public boolean hasSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute(SESSION_KEY);
        Utils.log("Check Session: " + bean);
        if (null != bean && null != bean.getUserName() && !bean.getUserName().isBlank()) {
            return true;
        }
        return false;
    }

    public String getRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute(SESSION_KEY);
        Utils.log("Get role: " + bean);
        if (null != bean && null != bean.getUserName() && !bean.getUserName().isBlank()) {
            return bean.getRole();
        }
        return null;
    }
    
    public String getUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute(SESSION_KEY);
        Utils.log("Get UserName: " + bean);
        if (null != bean && null != bean.getUserName() && !bean.getUserName().isBlank()) {
            return bean.getUserName();
        }
        return null;
    }
    
    public String getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute(SESSION_KEY);
        Utils.log("Get UserName: " + bean);
        if (null != bean && null != bean.getUserId() && !bean.getUserId().isBlank()) {
            return bean.getUserId();
        }
        return null;
    }
    
    public void updateFirstName(HttpServletRequest request, String fname) {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute(SESSION_KEY);
        Utils.log("Update Name: " + bean);
        if (null != bean && null != bean.getUserId() && !bean.getUserId().isBlank()) {
            bean.setFname(fname);;
        }
    }


    /**
     * Begin their session for newly login users.
     */
    public void beginSession(HttpServletRequest request, String userId, String userName, String fname) {
        // default we use role as user
        beginSession(request, userId, userName, fname, Constants.ROLE_USER);
    }

    public void beginSession(HttpServletRequest request,
            String userId, String userName, String fname, String role) {
        SessionBean sessionBean = new SessionBean();
        sessionBean.setFname(fname);
        sessionBean.setUserId(userId);
        sessionBean.setUserName(userName);
        sessionBean.setRole(role);
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_KEY, sessionBean);
        Utils.log("Begin Session: " + sessionBean);
    }

    /**
     * End their sessions after users logout.
     */
    public void endSession(HttpServletRequest request) {
        //request.setAttribute(SESSION_KEY, null);
        request.getSession().invalidate();
    }

    public static SessionManager getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static SessionManager instance = new SessionManager();
    }
}
