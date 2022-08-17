package com.revature.repository;

import java.util.Set;

import com.revature.models.Products;

public interface ProductRepository
{
	Set<Products> findAllProducts();
	public void save(Products products);
	public void delete(Products products);
	public void update(Products products);

}
