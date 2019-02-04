package com.jdbc.JdbcDemp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

//Java Program To Call Stored Procedure With IN And OUT Parameters :
public class CallableStatement3 {

	static {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading is compledted");
		} catch (ClassNotFoundException e) {

			System.out.println("Driver loading is faild");
		}
	}

	public static void main(String[] args) {

		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe", "RISUSER_OWNER",
					"RISUSER_OWNER");
			System.out.println("Connection created.........");
			callableStatement = connection.prepareCall("{call P3(?,?)}");
			callableStatement.setInt(1, 123);
			
			
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			System.out.println("Stored procedure executed..........");
			callableStatement.execute();
			
			String grde =callableStatement.getString(2);
			System.out.println("Garde :"+grde);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {

			try {
				if (callableStatement != null) {
					callableStatement.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
					connection = null;

					System.out.println("connection closed");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
