package com.recipes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipes.entities.SignIn;
import com.recipes.entities.SignUpInfo;
import com.recipes.repository.SignUpRepository;

@Service
public class SignInServiceimpl implements SignInService {

	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String validateUser(SignIn signIn) {
		SignUpInfo findByUsername = this.signUpRepository.findByUsername(signIn.getUsername());
		boolean matches = passwordEncoder.matches(signIn.getPassword(), findByUsername.getPassword());
		if(matches) {
			return "true";
		}else {
			return "false";
		}
	}

}
