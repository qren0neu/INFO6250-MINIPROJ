package com.qiren.miniproj.bean;

public class UserBean {
	
	private String userId;
	private UserRegistrationBean userBean;
	
	public String getUserId() {
		return userId;
	}
	
	public UserRegistrationBean getUserBean() {
		return userBean;
	}
	
	public void setUserBean(UserRegistrationBean userBean) {
		this.userBean = userBean;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
