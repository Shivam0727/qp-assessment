package com.shivam.entities;

import jakarta.persistence.*;

@Entity
public class GroceryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private double price;
	private int inventory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public GroceryItem(Long id, String name, double price, int inventory) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
	}

	public GroceryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GroceryItem [id=" + id + ", name=" + name + ", price=" + price + ", inventory=" + inventory + "]";
	}

}
