package com.sunbeam.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.OwnerDao;
import com.sunbeam.DAO.PropertyDao;
import com.sunbeam.DTO.AddressDTO;
import com.sunbeam.DTO.OwnerDTO;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.Owner;
import com.sunbeam.entities.Property;
import com.sunbeam.entities.Role;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerDao ownerDao;
	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public Owner addOwner(OwnerDTO ownerDTO) {
		// TODO Auto-generated method stub
		Owner owner = modelMapper.map(ownerDTO, Owner.class);
		owner.setRole(Role.valueOf("OWNER"));
		return ownerDao.save(owner);
		
	}
	@Override
	public OwnerDTO getOwnerDetails(Long ownerid) {
		// TODO Auto-generated method stub
		Owner owner=ownerDao.findById(ownerid).orElseThrow();
		OwnerDTO ownerDTO = modelMapper.map(owner, OwnerDTO.class);
		return ownerDTO;
	}
	@Override
	public String updateOwnerAddress(Long id,AddressDTO addressDTO) {
		Address address = modelMapper.map(addressDTO, Address.class);
		Owner owner=ownerDao.findById(id).orElseThrow();
		owner.setOwnerAddress(address);
		
		
		return "added";
	}
	
	/*
	 * @Override public Set<Property> getPropertiesByOwnerId(Long ownerId) { // if
	 * (!ownerDao.existsById(ownerId)) { // throw new
	 * ResourceNotFoundException("Owner not found with ID: " + ownerId); // }
	 * Set<Property> allProperty = propertyDao.findByOwnerId(ownerId); return
	 * allProperty; }
	 */
}
