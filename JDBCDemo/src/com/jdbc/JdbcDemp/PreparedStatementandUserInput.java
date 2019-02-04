package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementandUserInput {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER", "RISUSER_OWNER");
		PreparedStatement preparedStatement =connection.prepareStatement("insert into student values(?,?,?,?)");
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("Enter student Id :");
			int id=scanner.nextInt();
			preparedStatement.setInt(1, id);
			System.out.println("Enter student Name :");
			String name=scanner.next();
			preparedStatement.setString(2, name);
			System.out.println("Enter student Marks:");
			int marks=scanner.nextInt();
			preparedStatement.setInt(3, marks);
			System.out.println("Enter student grade :");
			String grade=scanner.next();
			preparedStatement.setString(4, grade);
			preparedStatement.executeUpdate();
			
			System.out.println("Do you want to insert one more recode ? if yes press 1 else 2");
			int userInput =scanner.nextInt();
			
			if (userInput==1) {
				
			} else {
				System.exit(0);
			}
			
		}
		
	}
}
