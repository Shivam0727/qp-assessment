package com.shivam.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.entities.Order;
import com.shivam.entities.OrderItem;
import com.shivam.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// Service Method To Save Order 
	
	public Order createOrder(Order order) {
		order.setOrderDate(new Date());
		for (OrderItem item : order.getItems()) {
			item.setOrder(order);
		}
		return orderRepository.save(order);
	}
}
