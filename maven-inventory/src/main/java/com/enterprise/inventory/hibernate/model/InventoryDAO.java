package com.enterprise.inventory.hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class InventoryDAO {
	public static final String STORE_TYPE_WAREHOUSE = "W";
	public static final String STORE_TYPE_OFFICE = "O";

	private static final String PERSISTENCE_UNIT_NAME = "inventory";
	private static EntityManagerFactory factory;

	public InventoryDAO() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public void addStore(String type, String name, int locationId) throws InventoryException {
		EntityManager em = factory.createEntityManager();
		String error = null;
		try {
			Location location = em.find(Location.class, locationId);
			if (location != null) {
				
				if (!doesStoreExists(em, type, name, locationId)) {
					Store store = new Store();
					store.setStoreType(type);
					store.setName(name);
					store.setLocation(location);
					
					em.getTransaction().begin();
					em.persist(store);
					em.getTransaction().commit();
				} else {
					error = "Store " + name + "already exists ";
				}
			} else {
				error = "Invalid store identity.";
			}

		} catch (Exception e) {
			throw new InventoryException("Could not add store." + e.getMessage());
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

		if (error != null) {
			throw new InventoryException("Failed to add Store. " + error);
		}
	}

	public boolean doesStoreExists (EntityManager em, String type, String name, int locationId) {
		boolean exists = false;
		
		StringBuilder builder = new StringBuilder();
		builder.append("select count(s.storeId) from Store as s where ");
		builder.append("storeType = '");
		builder.append(type);
		builder.append("' AND name = '");
		builder.append(name);
		builder.append("' AND location_locationId = ");
		builder.append(locationId);
		TypedQuery<Long> query = em.createQuery(builder.toString(), Long.class);
				
		if (query.getSingleResult() > 0) {
			exists = true;
		}

		return exists; 
	}

	public List<Location> getLocations() {

		EntityManager em = factory.createEntityManager();

		TypedQuery<Location> query = em.createQuery("select a from Location a", Location.class);
		List<Location> results = query.getResultList();

		return results;
	}

}
