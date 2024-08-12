package com.sunbeam.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

public interface AdminDao extends JpaRepository<User, Long> {
	 @Query("select u from User u where u.role = ?1")
	  List<User> findByRole(Role role);
}
