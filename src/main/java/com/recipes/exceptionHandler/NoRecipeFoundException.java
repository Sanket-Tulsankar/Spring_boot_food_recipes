package com.recipes.exceptionHandler;

public class NoRecipeFoundException extends Exception{

	public String msg;
	
	public NoRecipeFoundException(String msg) {
		super(msg);
		this.msg=msg;
	}
}
