package com.revature.service;

import java.util.Set;

import com.revature.models.Customer;
import com.revature.repository.CustomerRepository;
import com.revature.repository.CustomerRepositoryImpl;

public class CustomerService
{
	private CustomerRepository customerRepository;
	
	public CustomerService()
	{
		this.customerRepository = CustomerRepositoryImpl.getCustomerRepository();
	}
	
	public Set<Customer> findAllCustomers()
	{
		return this.customerRepository.findAllCustomers();
	}
	
	public void save(Customer customer)
	{
		this.customerRepository.save(customer);
	}
	
	public void delete(Customer customer)
	{
		this.customerRepository.delete(customer);
	}
	
	public void update(Customer customer)
	{
		this.customerRepository.update(customer);
	}
	
}
