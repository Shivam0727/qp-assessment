package com.shivam.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shivam.entities.GroceryItem;
import com.shivam.services.GroceryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private GroceryService groceryService;

	// Saving The Grocery Item Into Database :
	
	@PostMapping("/groceries")
	public ResponseEntity<GroceryItem> addGrocery(@RequestBody GroceryItem groceryItem) {
		GroceryItem savedItem = groceryService.addGrocery(groceryItem);
		return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
	}

	// Fetching The All Grocery Item From Database :
	
	@GetMapping("/groceries")
	public ResponseEntity<List<GroceryItem>> getAllGroceries() {
		List<GroceryItem> groceries = groceryService.getAllGroceries();
		return new ResponseEntity<>(groceries, HttpStatus.OK);
	}
	
	// Deleting The Grocery Item From Database :

	@DeleteMapping("/groceries/{id}")
	public ResponseEntity<Void> deleteGrocery(@PathVariable Long id) {
		groceryService.deleteGrocery(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Updating The Grocery Item From Database :
	
	@PutMapping("/groceries/{id}")
	public ResponseEntity<GroceryItem> updateGrocery(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
		GroceryItem updatedItem = groceryService.updateGrocery(id, groceryItem);
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	}

	// Updating The Inventory Of Grocery Item Item Into Database :
	
	@PatchMapping("/groceries/{id}/inventory")
	public ResponseEntity<GroceryItem> updateInventory(@PathVariable Long id, @RequestBody int inventory) {
		GroceryItem updatedItem = groceryService.updateInventory(id, inventory);
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	}
}
