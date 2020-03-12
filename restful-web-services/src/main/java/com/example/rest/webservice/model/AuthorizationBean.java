package com.example.rest.webservice.model;

public class AuthorizationBean {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthorizationBean(String message) {
		super();
		this.message = message;
	}

	public AuthorizationBean() {}

	@Override
	public String toString() {
		return "AuthorizationBean [message=" + message + "]";
	} 
	
	

}
