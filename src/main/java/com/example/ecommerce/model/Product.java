package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="product")
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String shoes;
	private String clothes;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long id, String shoes, String clothes) {
		super();
		this.id = id;
		this.shoes = shoes;
		this.clothes = clothes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getShoes() {
		return shoes;
	}
	public void setShoes(String shoes) {
		this.shoes = shoes;
	}
	public String getClothes() {
		return clothes;
	}
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	
	

}
