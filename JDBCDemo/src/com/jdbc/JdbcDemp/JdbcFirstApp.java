package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1.Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully........");

		// 2.Create the connection

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523", "RISUSER_OWNER",
				"RISUSER_OWNER");
		System.out.println("Connection created successfully......." + connection);

		// 3. Write the query

		String query = "create table emp(eid number, empname varchar2(35),esal number)";

		// 4 process the query
		Statement statement = connection.createStatement();
		int x = statement.executeUpdate(query);
		System.out.println("Table creates successfully............." + x);

		// 5.close the resources

		statement.close();
		connection.close();
		System.out.println("Connections closed sucessfully.............");

	}

}
