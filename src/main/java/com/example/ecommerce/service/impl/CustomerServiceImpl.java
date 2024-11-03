package com.example.ecommerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.CustomerLogin;
import com.example.ecommerce.model.CustomerRegistration;
import com.example.ecommerce.model.LoginStatus;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerRegistration saveCustomer(CustomerRegistration customerRegistration) {
		return customerRepository.save(customerRegistration);
	}

	@Override
	public LoginStatus loginCustomer(CustomerLogin customerLogin) {
		CustomerRegistration customerRegistrationemail = customerRepository.findByCustomerEmail(customerLogin.getCustomerEmail());
		if(customerRegistrationemail != null) {
			String loginPassword = customerLogin.getCustomerPassword();
			String registrationPassword = customerRegistrationemail.getCustomerPassword();
			if(registrationPassword.equals(loginPassword) ) {
				Optional<CustomerRegistration> customerRegistration = customerRepository.findByCustomerEmailAndCustomerPassword(customerLogin.getCustomerEmail(), customerRegistrationemail.getCustomerPassword());
				if(customerRegistration.isPresent()) {
					return new LoginStatus("Login Success", true);
				}else {
					return new LoginStatus("Login Failed", false);
				}
			}else {
				return new LoginStatus("Incorrect Password", false);
			}
		}else {
			return new LoginStatus("Incorrect Email", false);
		}
	}

	
}
