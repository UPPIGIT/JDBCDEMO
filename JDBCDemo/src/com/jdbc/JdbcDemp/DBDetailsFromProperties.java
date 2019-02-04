package com.jdbc.JdbcDemp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBDetailsFromProperties {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\git\\CoreJava\\Jdbc\\JDBCDemo\\src\\DB.Properties"));

		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));

		Class.forName(properties.getProperty("driver"));

		Connection connection =DriverManager.getConnection(properties.getProperty("url"), properties);
		System.out.println(connection);
		System.out.println("connection craeated .........");
		
	}
}
