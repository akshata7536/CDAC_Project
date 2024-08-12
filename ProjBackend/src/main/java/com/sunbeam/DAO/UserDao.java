package com.sunbeam.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
	List<User> findByRole(Role role);
	Optional<User> findByEmailAndPassword(String email, String pwd);
}
