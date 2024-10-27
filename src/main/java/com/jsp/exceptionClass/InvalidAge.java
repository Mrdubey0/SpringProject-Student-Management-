package com.jsp.exceptionClass;

public class InvalidAge extends RuntimeException{
private String message = "Invalid input";
	
	public InvalidAge(String message) {
		super();
		this.message = message;
		
	}
	public InvalidAge() {
		super();
		
		
	}
	@Override
	public String getMessage() {
		
		return this.message;
	}

}
