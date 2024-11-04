package com.example.ecommerce.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String orderDescription;
	
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private CustomerRegistration customerRegistration;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Cart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<Cart> cart;
    
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long id, String orderDescription, CustomerRegistration customerRegistration, List<Cart> cart) {
		super();
		this.id = id;
		this.orderDescription = orderDescription;
		this.customerRegistration = customerRegistration;
		this.cart = cart;

	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public CustomerRegistration getCustomerRegistration() {
		return customerRegistration;
	}
	public void setCustomerRegistration(CustomerRegistration customerRegistration) {
		this.customerRegistration = customerRegistration;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}


	
    
    
    

}
