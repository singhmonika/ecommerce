package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/ecommerce")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addproduct")
	public Product saveProduct(@RequestBody Product product){
		return this.productService.saveProduct(product);
		
	}
	
	@GetMapping("/getproduct")
	public List<Product> fetchProduct(){
		return this.productService.getProduct();
	}
	
	@GetMapping("/getproductById/{Id}")
	public Product fetchProductById(@PathVariable String Id) {
		return this.productService.getProductById(Long.parseLong(Id));
	}

}
