package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.CustomerLogin;
import com.example.ecommerce.model.CustomerRegistration;
import com.example.ecommerce.model.LoginStatus;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/api/ecommerce")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registerCustomer")
	public CustomerRegistration saveProduct(@RequestBody CustomerRegistration customerRegistration){
		return this.customerService.saveCustomer(customerRegistration);
		
	}
	
	@PostMapping("/loginCustomer")
	public LoginStatus loginCustomer(@RequestBody CustomerLogin customerLogin) {
		return this.customerService.loginCustomer(customerLogin);
	}

}
