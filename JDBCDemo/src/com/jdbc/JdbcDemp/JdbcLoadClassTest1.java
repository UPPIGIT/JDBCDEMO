package com.jdbc.JdbcDemp;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class JdbcLoadClassTest1 {

	public static void main(String[] args) throws ClassNotFoundException {

		// Load Driver class -approach 1

		// Class.forName("oracle.jdbc.OracleDriver");
		Class.forName("oracle.jdbc.driver.OracleDriver");

		System.out.println("Oreacle Driever classs loaded successfully........");
		
		Enumeration<Driver> enumeration = DriverManager.getDrivers();
		while (enumeration.hasMoreElements()) {
			Driver driver = (Driver) enumeration.nextElement();
			System.out.println(driver.getClass().getName());

		}

	}

}
