package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.CustomerRegistration;
import java.util.List;


public interface CustomerRepository extends JpaRepository<CustomerRegistration, Long>{
	Optional<CustomerRegistration> findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
	CustomerRegistration findByCustomerEmail(String customerEmail);

}
