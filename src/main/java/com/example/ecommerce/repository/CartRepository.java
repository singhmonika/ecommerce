package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
