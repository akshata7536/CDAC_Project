package com.sunbeam.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Tenant;

public interface TenantDao extends JpaRepository<Tenant, Long>{

}
