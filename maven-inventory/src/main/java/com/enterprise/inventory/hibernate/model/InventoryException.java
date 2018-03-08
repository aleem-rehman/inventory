package com.enterprise.inventory.hibernate.model;

public class InventoryException extends Exception {

	/**
	 * For handling serializable requirement. 
	 */
	private static final long serialVersionUID = 515508954785803649L;

	public InventoryException (String message) {
		super (message);
	}
	
}
