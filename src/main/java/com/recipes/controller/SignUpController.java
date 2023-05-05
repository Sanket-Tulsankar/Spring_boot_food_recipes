package com.recipes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.entities.SignUpInfo;
import com.recipes.exceptionHandler.UserNotFoundException;
import com.recipes.services.SignUpService;

@RestController
@CrossOrigin
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/create")
	public ResponseEntity<SignUpInfo> createUser(@RequestBody SignUpInfo signUpInfo) throws Exception {
		String password = signUpInfo.getPassword();
		passwordEncoder.encode(password);
		SignUpInfo createUser = this.signUpService.createUser(signUpInfo);
		return new ResponseEntity<SignUpInfo>(createUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<SignUpInfo> getSingleUser(@PathVariable long id) throws UserNotFoundException{
		//this.signUpService.getSingleUser(id);
		return new ResponseEntity<SignUpInfo>(this.signUpService.getSingleUser(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) throws UserNotFoundException{
		Optional<SignUpInfo> deletUser = this.signUpService.deletUser(id);
		return new ResponseEntity<Optional<SignUpInfo>>(deletUser,HttpStatus.OK);
	}
}
