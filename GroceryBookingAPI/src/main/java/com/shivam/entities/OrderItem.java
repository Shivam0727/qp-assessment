package com.shivam.entities;

import jakarta.persistence.*;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long groceryId;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(Long groceryId) {
		this.groceryId = groceryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderItem(Long id, Long groceryId, int quantity, Order order) {
		super();
		this.id = id;
		this.groceryId = groceryId;
		this.quantity = quantity;
		this.order = order;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", groceryId=" + groceryId + ", quantity=" + quantity + ", order=" + order + "]";
	}

}
