package com.qiren.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qiren.miniproj.bean.UserBean;
import com.qiren.miniproj.bean.UserRegistrationBean;
import com.qiren.miniproj.manager.ConnectionManager;
import com.qiren.miniproj.tools.Constants;

public class UserDAO {

	/**
	 * Create a new registered user
	 */
	public void createUserInfo(UserRegistrationBean bean) {
		Connection connection = ConnectionManager.getConnection();

		String sql = "INSERT INTO `mini_proj_web`.`user` (`pkUser`, `fname`, `lname`, `addr`, `city`, `state`, `postalcode`, `mobile`, `email`, `gender`, `birthday`, `role`, `username`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, MD5(?));";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, null);
			ps.setString(2, bean.getFname());
			ps.setString(3, bean.getLname());
			ps.setString(4, bean.getAddress1());
			ps.setString(5, bean.getCity());
			ps.setString(6, bean.getState());
			ps.setString(7, bean.getPostalCode());
			ps.setString(8, bean.getMobileNumber());
			ps.setString(9, bean.getEmail());
			ps.setString(10, bean.getGender());
			ps.setString(11, bean.getBirthday());
			ps.setString(12, Constants.ROLE_USER); // user is mean to be role '1'
			ps.setString(13, bean.getUsername());
			ps.setString(14, bean.getPassword());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.closeConnection(connection);
	}

	/**
	 * Get user info with user name, This is for search.
	 */
	public UserBean getUserInfo(String username) {
		Connection connection = ConnectionManager.getConnection();

		String sql = "SELECT * FROM mini_proj_web.user where username=?;";
		UserBean bean = null;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			bean = parseData(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.closeConnection(connection);
		return bean;
	}

	/**
	 * Get user info with username and password, This is for login.
	 */
	public UserBean getUserInfo(String username, String password) {
		Connection connection = ConnectionManager.getConnection();

		String sql = "SELECT * FROM mini_proj_web.user where username=? and password=MD5(?);";

		UserBean bean = null;
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			bean = parseData(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.closeConnection(connection);
		return bean;
	}

	private static UserBean parseData(ResultSet rs) {
		UserBean bean = null;

		try {
			if (rs.next()) {
				bean = new UserBean();
				UserRegistrationBean regisBean = new UserRegistrationBean();

				regisBean.setFname(rs.getString("fname"));
				regisBean.setLname(rs.getString("lname"));
				regisBean.setAddress1(rs.getString("addr"));
				regisBean.setCity(rs.getString("city"));
				regisBean.setState(rs.getString("state"));
				regisBean.setPostalCode(rs.getString("postalcode"));
				regisBean.setMobileNumber(rs.getString("mobile"));
				regisBean.setEmail(rs.getString("email"));
				regisBean.setGender(rs.getString("gender"));
				regisBean.setBirthday(rs.getString("birthday"));
				regisBean.setRole(rs.getString("role"));
				regisBean.setUsername(rs.getString("username"));
				regisBean.setPassword(rs.getString("password"));

				bean.setUserId(rs.getString("pkUser"));
				bean.setUserBean(regisBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bean;
	}
}
