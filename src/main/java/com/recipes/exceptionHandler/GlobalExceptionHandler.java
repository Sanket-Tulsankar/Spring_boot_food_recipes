package com.recipes.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException ex){
		String exceptionMsgString = ex.exceptionMsgString;
		return new ResponseEntity<String>(exceptionMsgString,HttpStatus.BAD_REQUEST);
	}
}
