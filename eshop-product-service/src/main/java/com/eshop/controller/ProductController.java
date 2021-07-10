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

import com.eshop.entity.Product;
import com.eshop.service.ProductService;

@RestController
@RequestMapping("/product/api")
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private ProductService productService;

	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		logger.info("saveProduct API (Controller) - {}", product);

		return productService.saveProduct(product);
	}

	@GetMapping
	public List<Product> findAllProducts() {
		logger.info("findAllProducts API (Controller) - Server Port - {}", environment.getProperty("local.server.port"));

		return productService.findAllProducts();
	}
}