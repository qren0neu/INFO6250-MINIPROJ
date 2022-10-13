package com.qiren.miniproj.tools;

public class Constants {
	public static final String ROLE_USER = "1";
	public static final String ROLE_STAFF = "0";
	
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST= "POST";

    public static final String PARAM_ACTION = "action";
    public static final String PARAM_ERROR = "error";
    public static final String PARAM_USER_BEAN = "userbean";
	
	/* Online MD5 hash: https://emn178.github.io/online-tools/md5.html */
	public static final String HASH_LOGIN = "d56b699830e77ba53855679cb1d252da";
    public static final String HASH_LOGOUT = "c93798b55ff7f793c2098e1c577d27aa";
	public static final String HASH_REGISTER = "9de4a97425678c5b1288aa70c1669a64";
	public static final String HASH_DASHBOARD_ADMIN = "09fed77547c060e78d3a667d2fffceca";
	public static final String HASH_DASHBOARD_USER = "f4c5f37ac762c823056c456d470f73d5";
	public static final String HASH_BOOKS_ADMIN = "6ca5734e58f6b665e5879f904f865b15";
	public static final String HASH_BOOKS_USER = "13d541cb4eda5e8336ba430376b6cd9e";
	public static final String HASH_ORDERS_ADMIN = "f926fc15325998725e466c0571c591b6";
	public static final String HASH_ORDERS_USER = "938f89ff5521f5689f020300d86ca18a";
    public static final String HASH_VIEW_USER = "97e1a767bfa5f33fbf116c3f80ee7334";
    public static final String HASH_VIEW_USER_LIST = "5c73f6e9fdbea4754eacff95793589c4";
    public static final String HASH_VIEW_USER_ADMIN = "2ec3dca8e1a81194fb071dd330492a22";
	
	public static final String ACTION_LOGIN = "login";
    public static final String ACTION_LOGOUT = "logout";
	public static final String ACTION_REGISTER = "register";
	public static final String ACTION_DASHBOARD = "dashboard";
    public static final String ACTION_BOOKS = "books";
    public static final String ACTION_BOOK_ORDER = "bookOrder";
    public static final String ACTION_USER_LIST = "userList";
    public static final String ACTION_VIEW_USER = "viewUser";
    
    public static final String WEB_INF = "WEB-INF/";
    public static final String PAGE_LOGIN = WEB_INF + "login/login.jsp";
    public static final String PAGE_REGISTER = WEB_INF + "register/RegistrationForm.html";
    public static final String PAGE_SUCCESS = WEB_INF + "result/success.jsp";
    public static final String PAGE_FAILED = WEB_INF + "result/failure.jsp";
    public static final String PAGE_DASHBOARD_USER = WEB_INF + "dashboard/userDashboard.jsp";
    public static final String PAGE_DASHBOARD_ADMIN = WEB_INF + "dashboard/adminDashboard.jsp";
    public static final String PAGE_VIEW_USER = WEB_INF + "user/viewInfo.jsp";
}
