package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}