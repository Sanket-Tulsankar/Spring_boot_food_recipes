package com.recipes.exceptionHandler;

public class UserNotFoundException extends Exception{

	String exceptionMsgString;

	public UserNotFoundException(String message) {
		super(message);
		this.exceptionMsgString=message;
	}
	
	
}
