package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public String readDataBase() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/sys", "root", "1234");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from rateme_poi");
			
		}
		catch (Exception e) {
			throw e;
		}
		finally {
			close();
		}
		return "ausgefuehrt";
	}
		
		private void close() {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (connect != null) {
					connect.close();
				}
			}catch (Exception e) {
				
			}
		}
	}
	


