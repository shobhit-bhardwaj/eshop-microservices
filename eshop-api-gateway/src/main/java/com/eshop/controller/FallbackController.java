package com.eshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/productFallback")
	public Mono<String> productServiceFallback() {
		return Mono.just("Product Service is taking too long to respond or is down. Please try again later.");
	}

	@RequestMapping("/orderFallback")
	public Mono<String> orderServiceFallback() {
		return Mono.just("Order Service is taking too long to respond or is down. Please try again later.");
	}

	@RequestMapping("/inventoryFallback")
	public Mono<String> inventoryServiceFallback() {
		return Mono.just("Inventory Service is taking too long to respond or is down. Please try again later.");
	}
}