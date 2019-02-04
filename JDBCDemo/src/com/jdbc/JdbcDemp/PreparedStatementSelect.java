package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
				"RISUSER_OWNER");

		PreparedStatement preparedStatement = connection.prepareStatement("select * from student where studentid=?");

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("Enter Student id  :");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				System.out.println("Student ID :" + resultSet.getInt(1));
				System.out.println("Student Name :" + resultSet.getString(2));
				System.out.println("Student Marks :" + resultSet.getInt(3));
				System.out.println("Student Grade :" + resultSet.getString(4));

			}

			System.out.println("DO you want to select one more record press 1 else 2");

			int userinput = scanner.nextInt();
			if (userinput == 1) {

			} else {
				System.out.println("Thanks you");
				System.exit(0);
			}

		}
	}

}
