package com.eshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
}