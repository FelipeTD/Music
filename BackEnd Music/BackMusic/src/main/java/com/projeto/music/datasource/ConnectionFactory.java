package com.projeto.music.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("banco.properties"));
			String theUser = props.getProperty("user");
			String thePassword = props.getProperty("password");
			String theDburl = props.getProperty("dburl");
			return DriverManager.getConnection(theDburl, theUser, thePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		if (myRs != null) {
			try {
				myRs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (myStmt != null) {
			try {
				myStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (myConn != null) {
			try {
				myConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
