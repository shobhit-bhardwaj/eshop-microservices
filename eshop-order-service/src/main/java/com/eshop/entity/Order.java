package com.eshop.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ORDER_MASTER")
public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	private BigDecimal orderAmount;
	private String orderStatus;

	@Transient
	private List<Inventory> inventories;
}