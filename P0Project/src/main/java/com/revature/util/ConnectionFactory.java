package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
	public static Connection getConnection()
	{

		/*
		 * .
		 */
		Connection conn = null;

		try
		{
			//need to edit this stupid connection
			conn = DriverManager.getConnection(System.getenv("db_url"), 
					System.getenv("db_username"),
					System.getenv("db_password"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return conn;
	}
}
