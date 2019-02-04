package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
				"RISUSER_OWNER");
		Statement statement = connection.createStatement();
		String drlquery = "select * from student";
		ResultSet resultSet = statement.executeQuery(drlquery);

		// know the no of columns in column data type
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int noOfColumns = resultSetMetaData.getColumnCount();
		System.out.println("No of columns in student table :" + noOfColumns);

		for (int i = 1; i <= noOfColumns; i++) {
			String columnName = resultSetMetaData.getColumnName(i);
			String datatype = resultSetMetaData.getColumnTypeName(i);
			System.out.println("column num :" + i + "..." + "column Name :" + columnName + "......"
					+ "column datatype :" + datatype);

		}

		// Retrieve data from db

		while (resultSet.next()) {

			System.out.println(resultSet.getInt("STUDENTID"));
			System.out.println(resultSet.getString("STUDENTNAME"));
			System.out.println(resultSet.getInt("STUDENTMARKS"));
			System.out.println(resultSet.getString("GRADE"));
		}

	}

}
