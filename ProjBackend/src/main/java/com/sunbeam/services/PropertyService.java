package com.sunbeam.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.sunbeam.DTO.PropertyDTO;
import com.sunbeam.entities.Property;

public interface PropertyService {
	public List<PropertyDTO> getAllProperties();

	public PropertyDTO getProperty(Long id);
	
	public Property addProperty(PropertyDTO propertyDTO,Long id);
	
	public PropertyDTO updateProperty(PropertyDTO propertyDTO,Long id);
//	public void deleteById(Long id);
	
	public String deleteProperty(Long id);
	
	public List<PropertyDTO> getAllProp(Long id) ;
	

}
