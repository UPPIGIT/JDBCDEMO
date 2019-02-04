package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreateTableProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load class
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("driver class loaded ......");
		// get connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
				"RISUSER_OWNER");
		System.out.println("connection created.........");
		Statement statement = connection.createStatement();
		
		String ddlDroptable ="drop table student";
		statement.execute(ddlDroptable);

		String dllCreatetable= "create table student (StudentId number, StudentName varchar2(50), StudentMarks number, Grade varchar2(50) )";
		statement.execute(dllCreatetable);
		System.out.println("Table created successfully.........");
		connection.close();
		statement.close();
		System.out.println("Connections closed..........");
	}
	
}
