package com.sunbeam.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.UserDao;
import com.sunbeam.DTO.OwnerDTO;
import com.sunbeam.DTO.SignInRequest;
import com.sunbeam.DTO.TenantsDTO;
import com.sunbeam.DTO.UserDTO;
import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserDao userDao;
	@Override
	public User addUser(UserDTO userDt) {
		// TODO Auto-generated method stub
		User user = modelMapper.map(userDt, User.class);
		
		return userDao.save(user);
	}
	@Override
	public Optional<User> getUserDetails(Long userId) {
		// TODO Auto-generated method stub
			
		return userDao.findById(userId);
	}
	@Override
	public UserDTO authenticateUser(SignInRequest request) {
		
		User userEntity = userDao.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new AuthenticationException("Invalid Email Or Password"));
		
		if(userEntity.getRole()== Role.valueOf("OWNER")) {
			return modelMapper.map(userEntity, OwnerDTO.class);
		}
		else if(userEntity.getRole()==Role.valueOf("TENANT")) {
			return modelMapper.map(userEntity, TenantsDTO.class);
		}
		else {
			return modelMapper.map(userEntity, UserDTO.class);
		}
	}
}
