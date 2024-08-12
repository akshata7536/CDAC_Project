package com.sunbeam.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long> {

}
