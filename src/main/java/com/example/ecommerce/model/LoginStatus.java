package com.example.ecommerce.model;

public class LoginStatus {
	private String message;
	private Boolean status;
	
	
	
	public LoginStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginStatus(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
