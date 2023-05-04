package com.recipes.services;

import java.util.List;
import java.util.Optional;

import com.recipes.entities.SignUpInfo;
import com.recipes.exceptionHandler.UserNotFoundException;

public interface SignUpService {

	public SignUpInfo createUser(SignUpInfo signUpInfo) throws Exception;

	public SignUpInfo getSingleUser(long id) throws UserNotFoundException;

	public List<SignUpInfo> getAllUsers() throws UserNotFoundException;

	public Optional<SignUpInfo> deletUser(long id) throws UserNotFoundException;
}
