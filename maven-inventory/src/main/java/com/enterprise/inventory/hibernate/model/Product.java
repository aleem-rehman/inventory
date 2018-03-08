package com.enterprise.inventory.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;

	private int availableQuantity;

	private int inStock;

	private int inTransit;

	private int minimumOrderQuantity;

	private String name;

	private int quantityPerBox;

	private int reorderPoint;

	private String type;

	//bi-directional many-to-many association to Location
	@ManyToMany
	@JoinTable(
		name="locationrestriction"
		, joinColumns={
			@JoinColumn(name="Product_ProductId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Location_LocationId")
			}
		)
	private List<Location> locations;

	//bi-directional many-to-one association to Size
	@ManyToOne
	private Size size;

	//bi-directional many-to-one association to Store
	@ManyToOne
	private Store store;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getInStock() {
		return this.inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	public int getMinimumOrderQuantity() {
		return this.minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(int minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityPerBox() {
		return this.quantityPerBox;
	}

	public void setQuantityPerBox(int quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	public int getReorderPoint() {
		return this.reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}