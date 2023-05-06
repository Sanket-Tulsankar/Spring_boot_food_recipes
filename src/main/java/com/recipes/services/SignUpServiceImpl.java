package com.recipes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipes.entities.SignUpInfo;
import com.recipes.exceptionHandler.UserNotFoundException;
import com.recipes.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public SignUpInfo createUser(SignUpInfo signUpInfo) throws Exception {
		// TODO Auto-generated method stub
		passwordEncoder.encode(signUpInfo.getPassword());
		SignUpInfo save = this.signUpRepository.save(signUpInfo);
		return save;
	}

	@Override
	public SignUpInfo getSingleUser(long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		SignUpInfo signUpInfo = this.signUpRepository.findById(id).orElseThrow(
				() -> new UserNotFoundException("User with id: " + id + " not found. Please enter correct id."));
		return signUpInfo;
	}

	@Override
	public List<SignUpInfo> getAllUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<SignUpInfo> list = this.signUpRepository.findAll();
		if (list.isEmpty()) {
			throw new UserNotFoundException("No users found !!");
		} else {
			return list;
		}
	}

	@Override
	public Optional<SignUpInfo> deletUser(long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		//Optional<SignUpInfo> findById = this.signUpRepository.findById(id);
		
		Optional<SignUpInfo> findById = this.signUpRepository.findById(id);
		
		if(findById.isPresent()) {
			this.signUpRepository.deleteById(id);
		}else {
			throw new UserNotFoundException("");
		}
		return findById;	
	}

}
