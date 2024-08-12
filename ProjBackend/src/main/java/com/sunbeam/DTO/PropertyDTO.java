package com.sunbeam.DTO;

import javax.persistence.Column;

import com.sunbeam.entities.Owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PropertyDTO {
	
	
	private String propType;
	
    private double propSize;
	
	private String title;
	
    private double price;
	
    private String flatType;

    private int bathrooms;
	
    private boolean isfurnished;
	
    private boolean isParking;
	
    private int balcony;
	
    private double rent;
	
    private double deposit;

//    private Owner owner;
	
	
	

}
