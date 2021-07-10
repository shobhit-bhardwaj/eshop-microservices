package com.eshop.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Inventory;
import com.eshop.repository.InventoryRepository;

@Service
public class InventoryService {
	private static final Logger logger = LogManager.getLogger(InventoryService.class);

	@Autowired
	private InventoryRepository inventoryRepository;

	@PostConstruct
	public void loadInventoryData() {
		List<Inventory> inventories = Arrays.asList(
				new Inventory("Laptop", 12),
				new Inventory("Mobile", 15),
				new Inventory("Ear Phone", 18));
		inventoryRepository.saveAll(inventories);
	}

	public Inventory saveInventory(Inventory inventory) {
		logger.info("saveInventory API (Service)");

		return inventoryRepository.save(inventory);
	}

	public List<Inventory> findAllInventories() {
		logger.info("findAllInventories API (Service)");

		return inventoryRepository.findAll();
	}

	public boolean checkAvailability(int inventoryId, int quantity) {
		logger.info("checkAvailability API (Service)");

		Inventory inventory = inventoryRepository.findById(inventoryId).orElse(new Inventory());
		return inventory.getQuantity() > quantity;
	}
}