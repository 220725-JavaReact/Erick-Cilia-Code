package com.revature.service;

import java.util.Set;

import com.revature.models.Products;
import com.revature.repository.ProductRepository;
import com.revature.repository.ProductRepositoryImpl;

public class ProductService
{
	private ProductRepository productRepository;
	
	public ProductService()
	{
		this.productRepository = ProductRepositoryImpl.getProductsRepository();
	}
	
	public Set<Products> findAllProducts()
	{
		return this.productRepository.findAllProducts();
	}
	
	public void save(Products products)
	{
		this.productRepository.save(products);
	}
	
	public void delete(Products products)
	{
		this.productRepository.delete(products);
	}
	
	public void update(Products products)
	{
		this.productRepository.update(products);
	}
}
