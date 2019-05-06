package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Product;

public class ProductRepository {
	
	public Product find() {
		return new Product("id1", "product1", 100.0);
	}
	
	
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("id1", "product1", 100.0));
		products.add(new Product("id2", "product2", 200.0));
		products.add(new Product("id13", "product3", 300.0));
		
		return products;
	}
}
