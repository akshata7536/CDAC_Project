package com.sunbeam.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.SignInRequest;
import com.sunbeam.entities.Owner;
import com.sunbeam.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@RequestBody 
			@Valid SignInRequest request) {
		System.out.println("in sign in " + request);
		
			return ResponseEntity
					.ok(userService.authenticateUser(request));
		
	}

}
