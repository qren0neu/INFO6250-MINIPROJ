package com.qiren.miniproj.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost/mini_proj_web";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

	private static final String USERNAME = "root";
	private static final String PASSWORD = "19961121";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
