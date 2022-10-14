package com.qiren.miniproj.bean;

public class SessionBean {
	
    private String userName;
	private String userId;
	private String fname;
	private String role;
	
	public void setUserName(String userName) {
        this.userName = userName;
    }
	
	public String getUserName() {
        return userName;
    }
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setRole(String role) {
        this.role = role;
    }
	
	public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "SessionBean [userId=" + userId + ", fname=" + fname + ", role=" + role + "]";
    }
}
