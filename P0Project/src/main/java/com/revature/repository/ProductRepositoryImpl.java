package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.models.Products;
import com.revature.util.ConnectionFactory;
import com.revature.util.ResourceCloser;

public class ProductRepositoryImpl implements ProductRepository
{
	public static ProductRepositoryImpl productRepository;

	public static synchronized ProductRepositoryImpl getProductsRepository()
	{
		if (productRepository == null)
		{
			productRepository = new ProductRepositoryImpl();
		}

		return productRepository;
	}

	@Override
	public Set<Products> findAllProducts()
	{
		// TODO Auto-generated method stub
		Set<Products> products = new HashSet<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "SELECT * FROM games";

		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();

			set = stmt.executeQuery(SQL);

			while (set.next())
			{
				products.add(new Products(set.getString(1), set.getDouble(2), set.getString(3)));
			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		} finally
		{
			// some code here
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return products;
	}

	@Override
	public void save(Products products)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "INSERT INTO games VALUES(?, ?, ?)";
		
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			
			stmt.setString(1, products.getName());
			stmt.setDouble(2, products.getCost());
			stmt.setString(3, products.getCategory());
			
			stmt.execute();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}

	}

	@Override
	public void delete(Products products)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String SQL = "DELETE FROM games WHERE game_name = ?";
		
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			
			stmt.setString(1, products.getName());
			stmt.execute();
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}

	}

	@Override
	public void update(Products products)
	{
		// TODO Auto-generated method stub

	}

}
