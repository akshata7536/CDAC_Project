package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Property extends BaseEntity{
    
	@Column(name = "property_type")
	private String propType;
	@Column(name = "property_size")
    private double propSize;
	@Column(length = 100)
	private String title;
	@Column
    private double price;
	@Column(name = "flat_type", length = 100)
    private String flatType;
	@Column 
    private int bathrooms;
	@Column
    private boolean isfurnished;
	@Column
    private boolean isParking;
	@Column
    private int balcony;
	@Column
    private double rent;
	@Column
    private double deposit;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "property_address")
    private Address propAddress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PropertyImages> images = new ArrayList<>();
    
    @Column(name="main_image")
    private String mainImgUrl;

}
