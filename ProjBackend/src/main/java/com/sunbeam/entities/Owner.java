package com.sunbeam.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Owner extends User{
	
	/*
	 * @Column(nullable = false,name="alterPhone_number", length = 10) private Long
	 * alterPhoneNo;
	 * 
	 * // @NotBlank(message = "enter adhar card number!") // @Size(min = 12, max =
	 * 12) // @Column(name = "adhar_id", unique = true,length=14) // private String
	 * adharId;
	 * 
	 * @NotBlank(message = "Aadhaar ID is required")
	 * 
	 * @Column(name = "adhar_id", length = 12, unique = true, nullable = false)
	 * private Long adharId;
	 * 
	 * // @NotBlank
	 * 
	 * @Column(name = "total_properties", nullable = false) private int
	 * totalProperties;
	 * 
	 * @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="owner_address_id") private Address ownerAddress;
	 */
	

    @NotBlank(message = "Alternate phone number is required")
    @Column(nullable = false, name = "alterPhone_number", length = 10)
    private String alterPhoneNo;
    
    @Embedded
    private AdharCard adharId;

    @Min(value = 0, message = "Total properties cannot be negative")
    @Column(name = "total_properties", nullable = false)
    private int totalProperties;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_address_id")
    private Address ownerAddress;
    
    @OneToMany
    @JoinColumn(name = "owner_id")
    private Set<Property> properties;
	
}
