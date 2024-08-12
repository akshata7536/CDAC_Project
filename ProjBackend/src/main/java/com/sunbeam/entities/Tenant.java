package com.sunbeam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
public class Tenant extends User {

	@OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private WishList wishlist;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "tenant_address_id")
	private Address tenantAddress;

}
