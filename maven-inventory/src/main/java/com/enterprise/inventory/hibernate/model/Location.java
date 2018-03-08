package com.enterprise.inventory.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int locationId;

	private String name;

	//bi-directional many-to-many association to Product
	@ManyToMany(mappedBy="locations")
	private List<Product> products;

	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="location")
	private List<Store> stores;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setLocation(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setLocation(null);

		return store;
	}

}