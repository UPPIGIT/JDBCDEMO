package com.jdbc.JdbcDemp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
				"RISUSER_OWNER");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
		
		preparedStatement.setInt(1, 222);
		preparedStatement.setString(2, "ABHI");
		preparedStatement.setInt(3, 520);
		preparedStatement.setString(4, "A");
		preparedStatement.executeUpdate();
		
		preparedStatement.setInt(1, 333);
		preparedStatement.setString(2, "NVN");
		preparedStatement.setInt(3, 498);
		preparedStatement.setString(4, "B");
		preparedStatement.executeUpdate();
	}

}
