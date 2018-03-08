package com.enterprise.inventory.spring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enterprise.inventory.hibernate.model.InventoryDAO;
import com.enterprise.inventory.hibernate.model.InventoryException;
import com.enterprise.inventory.hibernate.model.Location;

@Controller
@EnableAutoConfiguration
public class InventoryController {

	InventoryDAO inventoryDAO;

	public InventoryController() {
		inventoryDAO = new InventoryDAO();
	}

	@RequestMapping("/")
	@ResponseBody
	String inventoryServiceHome() {
		return "This is Inventory Service";
	}

	@RequestMapping("/getLocations")
	@ResponseBody
	String getLocations() {
		List<Location> locations = inventoryDAO.getLocations();
		StringBuffer buffer = new StringBuffer();

		for (Location loc : locations) {
			buffer.append(loc.getLocationId());
			buffer.append(" ");
			buffer.append(loc.getName());
			buffer.append(" ---  ");
		}

		return buffer.toString();
	}

	@RequestMapping("/addWarehouse")
	@ResponseBody
	String addWarehouse(@RequestParam(value = "name") String name, @RequestParam(value = "locationId") String id) {

		try { 
			inventoryDAO.addStore(InventoryDAO.STORE_TYPE_WAREHOUSE, name, Integer.parseInt(id));
		} catch (InventoryException e) {
			return e.getMessage();
		}
		return "Sucessfully added Warehouse " + name;
	}

//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(InventoryController.class, args);
//	}
}