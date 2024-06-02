package com.shivam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shivam.entities.GroceryItem;
import com.shivam.entities.Order;
import com.shivam.services.GroceryService;
import com.shivam.services.OrderService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private GroceryService groceryService;

	@Autowired
	private OrderService orderService;

	// Fetching The Grocery Item From Database :

	@GetMapping("/groceries")
	public ResponseEntity<List<GroceryItem>> getAllGroceries() {
		List<GroceryItem> groceries = groceryService.getAllGroceries();
		return new ResponseEntity<>(groceries, HttpStatus.OK);
	}

	// Saving The Order Created By User Into Database

	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		Order createdOrder = orderService.createOrder(order);
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}
}
