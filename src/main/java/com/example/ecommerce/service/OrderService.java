package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Order;

public interface OrderService {
	public Order getOrderDetails(long Id);
	public float getCartAmount(List<Cart> cartList);
	public Order saveOrder(Order order);

}
