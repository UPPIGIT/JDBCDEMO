package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver loaded.........");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
				"RISUSER_OWNER");
		System.out.println("connection created.....");

		Statement statement = connection.createStatement();
		String drlSelect = "select * from student";
		ResultSet resultSet = statement.executeQuery(drlSelect);

		while (resultSet.next()) {

			System.out.println("Student Id:" + resultSet.getInt(1));
			System.out.println("Student Name:" + resultSet.getString(2));
			System.out.println("Student Marks :" + resultSet.getInt(3));
			System.out.println("Student grade :" + resultSet.getString(4));
			System.out.println("-------------------------------------");

		}
		
		connection.close();
		statement.close();
		
		System.out.println("connections closed");
		

	}
}
