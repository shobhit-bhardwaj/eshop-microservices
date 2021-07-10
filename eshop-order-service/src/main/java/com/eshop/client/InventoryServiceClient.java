package com.eshop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="inventory-service", path="/inventory/api")
public interface InventoryServiceClient {

	@GetMapping("/{inventoryId}")
	public boolean checkAvailability(@PathVariable int inventoryId, @RequestParam int quantity);
}