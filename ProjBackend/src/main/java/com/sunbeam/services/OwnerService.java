package com.sunbeam.services;

import java.util.Set;

import com.sunbeam.DTO.AddressDTO;
import com.sunbeam.DTO.OwnerDTO;
import com.sunbeam.entities.Owner;
import com.sunbeam.entities.Property;

public interface OwnerService {
	public Owner addOwner(OwnerDTO ownerDTO);
	public OwnerDTO getOwnerDetails(Long ownerid);
	public String updateOwnerAddress(Long id,AddressDTO addressDTO);
	//public Set<Property> getPropertiesByOwnerId(Long ownerId);
}
