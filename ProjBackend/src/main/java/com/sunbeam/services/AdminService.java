package com.sunbeam.services;

import java.util.List;

import com.sunbeam.DTO.OwnerDTO;
import com.sunbeam.DTO.TenantsDTO;

public interface AdminService {
	public List<TenantsDTO> getAllTenants();
	public List<OwnerDTO> getAllOwners();
	public String blockUser(Long id);
	public String UnblockUser(Long id);
}
