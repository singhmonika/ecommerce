package com.example.ecommerce.model;

public class OrderResponse {
	private float amount;
	private long invoiceNumber;
	private String date;
	private String OrderDescription;
	private long OrderId;
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderResponse(float amount, long invoiceNumber, String date, String orderDescription, long orderId) {
		super();
		this.amount = amount;
		this.invoiceNumber = invoiceNumber;
		this.date = date;
		OrderDescription = orderDescription;
		OrderId = orderId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderDescription() {
		return OrderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		OrderDescription = orderDescription;
	}
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	
	

}
