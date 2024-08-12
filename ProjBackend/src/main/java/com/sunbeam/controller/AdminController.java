package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@GetMapping("/tenants")
	public ResponseEntity<?> getCustomers(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllTenants());
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	@GetMapping("/owners")
	public ResponseEntity<?> getSellers(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllOwners());
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	@PatchMapping("/block/{id}")
	public ResponseEntity<?> blockUser(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adminService.blockUser(id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	@PatchMapping("/Unblock/{id}")
	public ResponseEntity<?> unblockUser(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adminService.UnblockUser(id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
