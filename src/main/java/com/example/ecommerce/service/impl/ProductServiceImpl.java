package com.example.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	
	public Product saveProduct(Product product) {
		productRepository.save(product);
		return product;
	}





	@Override
	public Product getProductById(long Id) {
		return productRepository.findById(Id).get();
	}





	@Override
	public List<Product> getProduct() {
		return productRepository.findAll();
	}


	

}
