package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceCloser
{
	public static void closeConnection(Connection conn)
	{
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement stmt)
	{
		try
		{
			stmt.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet set)
	{
		try
		{
			set.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
