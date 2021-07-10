package com.eshop.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Product;
import com.eshop.repository.ProductRepository;

@Service
public class ProductService {
	private static final Logger logger = LogManager.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		logger.info("saveProduct API (Service)");

		return productRepository.insert(product);
	}

	public List<Product> findAllProducts() {
		logger.info("findAllProducts API (Service)");

		return productRepository.findAll();
	}
}