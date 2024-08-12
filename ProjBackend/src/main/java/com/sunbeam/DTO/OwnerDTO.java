package com.sunbeam.DTO;

import com.sunbeam.entities.Address;
import com.sunbeam.entities.AdharCard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO extends UserDTO {
	private Long alterPhoneNo;
	private AdharCard adharId;
	private int totalProperties;
	private AddressDTO ownerAddress;
}
