package com.eshop.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Order;
import com.eshop.service.OrderService;

@RestController
@RequestMapping("/order/api")
public class OrderController {
	private static final Logger logger = LogManager.getLogger(OrderController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private OrderService orderService;

	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		logger.info("saveOrder API (Controller) - {}", order);

		return orderService.saveOrder(order);
	}

	@GetMapping
	public List<Order> findAllOrders() {
		logger.info("findAllOrders API (Controller) - Server Port - {}", environment.getProperty("local.server.port"));

		return orderService.findAllOrders();
	}
}