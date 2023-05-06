package com.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.entities.SignIn;
import com.recipes.services.SignInService;

@RestController
@RequestMapping("/signin")
@CrossOrigin
public class SignInController {

	@Autowired
	private SignInService signInService;

	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody SignIn signIn){
		//System.out.println("in validate controller");
		String validateUser = this.signInService.validateUser(signIn);
		return new ResponseEntity<String>(validateUser,HttpStatus.OK);
	}
}
