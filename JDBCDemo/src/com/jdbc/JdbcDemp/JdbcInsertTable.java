package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertTable {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully.......");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
					"RISUSER_OWNER");
			System.out.println("connection created successfully.......");

			Statement statement = connection.createStatement();

			String dmlinsert = "insert into student values(111,'upender','507','A')";

			statement.executeUpdate(dmlinsert);

			System.out.println("student record insert sucssesfully");

			connection.close();
			statement.close();

			System.out.println("connections closed");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
