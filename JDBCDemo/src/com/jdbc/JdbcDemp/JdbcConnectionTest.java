package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionTest {
	
	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loaded.......");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
				Connection connection=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","RISUSER_OWNER", "RISUSER_OWNER");
				System.out.println("Connection created");
	}

}
