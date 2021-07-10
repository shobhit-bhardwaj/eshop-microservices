package com.eshop.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.eshop.client.InventoryServiceClient;
import com.eshop.entity.Order;
import com.eshop.repository.OrderRepository;

@Service
public class OrderService {
	private static final Logger logger = LogManager.getLogger(OrderService.class);

	@Autowired
	private InventoryServiceClient inventoryServiceClient;

	@Autowired
	private OrderRepository orderRepository;

	@Value("${kafka.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Message<String>> kafkaTemplate;

	public Order saveOrder(Order order) {
		logger.info("saveOrder API (Service)");

		boolean available = order.getInventories().stream()
				.allMatch(inventory -> inventoryServiceClient.checkAvailability(inventory.getInventoryId(), inventory.getQuantity()));
		logger.info("available Inventory - {}", available);

		String prefixMessage;
		if(available) {
			order.setOrderStatus("ORDER_PLACED");
			prefixMessage = "Order Placed Successfully - ";
		} else {
			order.setOrderStatus("ORDER_CANCELLED");
			prefixMessage = "Order Cancelled - ";
		}

		order = orderRepository.save(order);
		logger.info("Order Saved - {}", order);

		Message<String> notificationMessage = MessageBuilder.withPayload(prefixMessage + order.getOrderId()).build();
		kafkaTemplate.send(topicName, notificationMessage);

		return order;
	}

	public List<Order> findAllOrders() {
		logger.info("findAllOrders API (Service)");

		return orderRepository.findAll();
	}
}