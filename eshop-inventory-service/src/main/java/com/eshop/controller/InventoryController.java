package com.eshop.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Inventory;
import com.eshop.service.InventoryService;

@RestController
@RequestMapping("/inventory/api")
public class InventoryController {
	private static final Logger logger = LogManager.getLogger(InventoryController.class);

	@Autowired
	private InventoryService inventoryService;

	@PostMapping
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		logger.info("saveInventory API (Controller) - {}", inventory);

		return inventoryService.saveInventory(inventory);
	}

	@GetMapping
	public List<Inventory> findAllInventories() {
		return inventoryService.findAllInventories();
	}

	@GetMapping("/{inventoryId}")
	public boolean checkAvailability(@PathVariable int inventoryId, @RequestParam int quantity) {
		logger.info("checkAvailability API (Controller) - Inventory Id - {}, Quantity - {}", inventoryId, quantity);

		return inventoryService.checkAvailability(inventoryId, quantity);
	}
}