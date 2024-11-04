package com.example.ecommerce.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.CustomerRegistration;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderResponse;
import com.example.ecommerce.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	 @GetMapping(value = "/getOrder/{orderId}")
	    public Order fetchOrderDetails(@PathVariable int orderId) {
		return orderService.getOrderDetails(orderId);
	    }


	    @PostMapping("/placeOrder")
	    public ResponseEntity<OrderResponse> placeOrder(@RequestBody Order order) {
	        System.out.println("Request Payload " + order.toString());
	        OrderResponse orderResponse = new OrderResponse();
	        CustomerRegistration customer = new CustomerRegistration();
	        float amount = orderService.getCartAmount(order.getCart());
	        Order order1 = new Order(order.getId(),order.getOrderDescription(), customer, order.getCart());
	        order = orderService.saveOrder(order);
	        System.out.println("Order processed successfully..");

	        orderResponse.setAmount(amount);
//	        orderResponse.setDate(getCurrentDateTime());
	        orderResponse.setInvoiceNumber(new Random().nextInt(1000));
	        orderResponse.setOrderId(order.getId());
	        orderResponse.setOrderDescription(order.getOrderDescription());

	        return ResponseEntity.ok(orderResponse);
	    }

}
