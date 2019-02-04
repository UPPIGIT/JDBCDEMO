package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDeleteRecords {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
				"RISUSER_OWNER");

		PreparedStatement preparedStatement = connection.prepareStatement("delete from student where studentid=?");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			System.out.println("Enter Student id whic do want delete :");
			int id =scanner.nextInt();
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			System.out.println("DO you want to delete one more recode press 1 else 2");
			
			int userinput =scanner.nextInt();
			if (userinput==1) {
				
			} else {
				System.out.println("Thanks you");
				System.exit(0);
			}
			
			
			

		}
	}

}
