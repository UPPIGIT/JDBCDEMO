package com.jdbc.JdbcDemp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Java Program To Call Stored Procedure With No Parameters :*/
public class CallableStatementDemo {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded........");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the driver class");
		}
	}

	public static void main(String[] args) {

		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
					"RISUSER_OWNER");
			System.out.println("connection created");
			callableStatement = connection.prepareCall("{call P1}");
			callableStatement.execute();
			System.out.println("stored procedure executed .........");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			
			try {
				if (callableStatement!=null) {
					callableStatement.close();
					callableStatement=null;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			try {
				if (connection!=null) {
					connection.close();
					connection=null;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}
