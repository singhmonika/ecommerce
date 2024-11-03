package com.example.ecommerce.service;

import com.example.ecommerce.model.CustomerLogin;
import com.example.ecommerce.model.CustomerRegistration;
import com.example.ecommerce.model.LoginStatus;

public interface CustomerService {
	public CustomerRegistration saveCustomer(CustomerRegistration customerRegistration);
	
	LoginStatus loginCustomer(CustomerLogin customerLogin);

}
