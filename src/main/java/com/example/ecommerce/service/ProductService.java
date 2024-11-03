package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Product;

public interface ProductService {
	public List<Product> getProduct();
	
	public Product saveProduct(Product product); 
	
	public Product getProductById(long Id);

}
