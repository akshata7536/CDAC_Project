package com.sunbeam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.AddressDTO;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.OwnerDTO;
import com.sunbeam.entities.Property;
import com.sunbeam.services.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	@PostMapping
	public ResponseEntity<?> addNewOwner(@RequestBody OwnerDTO ownerdto){
		System.out.println("in add new user"+ownerdto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.addOwner(ownerdto));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOwner(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ownerService.getOwnerDetails(id));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	@PutMapping("/Address/{id}")
	public ResponseEntity<?> updateOwnerAddress(@PathVariable Long id,@RequestBody AddressDTO addressDTO){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ownerService.updateOwnerAddress(id, addressDTO));
		}
		catch(RuntimeException e){
			System.out.println("error"+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	/*
	 * @GetMapping("/OwnerProperties/{id}") public ResponseEntity<Set<Property>>
	 * getPropertiesByOwnerId(@PathVariable Long id) { Set<Property> properties =
	 * ownerService.getPropertiesByOwnerId(id); return
	 * ResponseEntity.ok(properties); }
	 */
}