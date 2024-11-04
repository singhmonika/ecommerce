package com.example.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Order saveOrder(Order order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order getOrderDetails(long Id) {
		Optional<Order> order = Optional.ofNullable(orderRepository.findById(Id).get());
		return order.isPresent() ? order.get():null;
	}

	@Override
	public float getCartAmount(List<Cart> cartList) {
        float totalCartAmount = 0f;
        float singleCartAmount = 0f;
        long availableQuantity = 0l;
        for(Cart cart : cartList) {
            long productId = cart.getProductId();
            Optional<Product> product = productRepository.findById(productId);
            if (product.isPresent()) {
                Product product1 = product.get();
                if (product1.getQuantityAvailable() < cart.getQuantity()) {
                    singleCartAmount = product1.getPrice() * product1.getQuantityAvailable();
                    cart.setQuantity(product1.getQuantityAvailable());
                } else {
                    singleCartAmount = cart.getQuantity() * product1.getPrice();
                    availableQuantity = product1.getQuantityAvailable() - cart.getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                product1.setQuantityAvailable(availableQuantity);
                availableQuantity=0;
                cart.setProductName(product1.getProductName());
                cart.setAmount(singleCartAmount);
                productRepository.save(product1);
            }
        }
        return totalCartAmount;
	}

}
