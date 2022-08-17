package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.ResourceCloser;

public class CustomerRepositoryImpl implements CustomerRepository
{

	public static CustomerRepositoryImpl customerRepository;

	public static synchronized CustomerRepositoryImpl getCustomerRepository()
	{
		if (customerRepository == null)
		{
			customerRepository = new CustomerRepositoryImpl();
		}

		return customerRepository;
	}

	@Override
	public Set<Customer> findAllCustomers()
	{
		// TODO Auto-generated method stub
		Set<Customer> customer = new HashSet<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		final String SQL = "SELECT * FROM customer";
		
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			
			set = stmt.executeQuery(SQL);
			
			while(set.next())
			{
				customer.add(new Customer(
						set.getString(1),
						set.getString(2),
						set.getString(3)
						));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

			

		return customer;
	}

	@Override
	public void save(Customer customer)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "INSERT INTO customer VALUES(?, ?, ?)";
		
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getAddress());
			stmt.setString(3, customer.getEmail());
			
			stmt.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}

	}

	@Override
	public void delete(Customer customer)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String SQL = "DELETE FROM customer WHERE user_name = ?";
		
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customer.getName());
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
	public void update(Customer customer)
	{
		// TODO Auto-generated method stub

	}

}
