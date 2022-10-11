package com.qiren.miniproj.service;

import com.qiren.miniproj.bean.UserBean;
import com.qiren.miniproj.bean.UserRegistrationBean;
import com.qiren.miniproj.dao.UserDAO;

public class UserService {

	private UserDAO userdao;

	private UserService() {

	}

	public void createUserInfo(UserRegistrationBean bean) {
		userdao.createUserInfo(bean);
	}

	public UserBean getUserInfo(String username) {
		return userdao.getUserInfo(username);
	}

	public UserBean getUserInfo(String username, String password) {
		return userdao.getUserInfo(username, password);
	}
	
	public boolean checkLoginInfo(String username, String password) {
		return null != userdao.getUserInfo(username, password);
	}

	public static UserService getInstance() {
		return Inner.instance;
	}

	private static class Inner {
		private static UserService instance = new UserService();
	}
}
