package com.qiren.miniproj.manager;

import com.qiren.miniproj.bean.SessionBean;

import jakarta.servlet.http.HttpServletRequest;

public class SessionManager {

	private static final String SESSION_KEY = "SESSION_KEY";

	private SessionManager() {

	}

	/**
	 * Check if the users are currently in their session.
	 */
	public boolean hasSession(HttpServletRequest request) {
		SessionBean bean = (SessionBean) request.getAttribute(SESSION_KEY);
		if (null != bean && null != bean.getUserId() && !bean.getUserId().isBlank()) {
			return true;
		}
		return false;
	}

	/**
	 * Begin their session for newly login users.
	 */
	public void beginSession(HttpServletRequest request, String userId, String fname) {
		SessionBean sessionBean = new SessionBean();
		sessionBean.setFname(userId);
		sessionBean.setUserId(fname);
		request.setAttribute(SESSION_KEY, sessionBean);
	}

	/**
	 * End their sessions after users logout.
	 */
	public void endSession(HttpServletRequest request) {
		request.setAttribute(SESSION_KEY, null);
	}

	public static SessionManager getInstance() {
		return Inner.instance;
	}

	private static class Inner {
		private static SessionManager instance = new SessionManager();
	}
}
