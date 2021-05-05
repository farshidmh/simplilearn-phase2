package com.sample.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	
	private Connection connection;
	
	
	public DbConnector(String dbUrl, String uname, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			connection = DriverManager.getConnection(dbUrl,uname,password);
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public Connection getConnection() {
		return connection;
	}
	
	
	

}
