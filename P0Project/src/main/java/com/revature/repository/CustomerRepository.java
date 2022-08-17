package com.revature.repository;

import java.util.Set;

import com.revature.models.Customer;


public interface CustomerRepository
{
	Set<Customer> findAllCustomers();//will be used for admin privileges
	public void save(Customer customer);
	public void delete(Customer customer);//for admin as well
	public void update(Customer customer);
}
