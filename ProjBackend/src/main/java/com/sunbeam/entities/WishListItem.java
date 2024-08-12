package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wishlist_items")
@Getter
@Setter
@NoArgsConstructor
public class WishListItem extends BaseEntity{
	@ManyToOne
    @JoinColumn(name = "wishlist_id", nullable = false)
    private WishList wishlist;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;


}
