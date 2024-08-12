package com.sunbeam.services;

import java.util.Optional;


import com.sunbeam.DTO.SignInRequest;
import com.sunbeam.DTO.UserDTO;

import com.sunbeam.entities.User;

public interface UserService {
	User addUser(UserDTO user);

	public Optional<User> getUserDetails(Long categoryId) ;
	public UserDTO authenticateUser(SignInRequest request);
}
