package com.shivam.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shivam.entities.GroceryItem;
import com.shivam.exceptions.GroceryIdNotFoundException;
import com.shivam.repositories.GroceryItemRepository;

@Service
public class GroceryService {

	@Autowired
	private GroceryItemRepository groceryItemRepository;

	// Service Method For Saving Grocery
	
	public GroceryItem addGrocery(GroceryItem groceryItem) {
		return groceryItemRepository.save(groceryItem);
	}

	// Service Method For Fetching Grocery
	
	public List<GroceryItem> getAllGroceries() {
		return groceryItemRepository.findAll();
	}

	// Service Method For Deleting Grocery
	
	public void deleteGrocery(Long id) {
		GroceryItem existingItem = groceryItemRepository.findById(id)
				.orElseThrow(() -> new GroceryIdNotFoundException("GroceryItem not found for this id :: " + id));
		groceryItemRepository.delete(existingItem);
	}
	
	// Service Method For Updating Grocery

	public GroceryItem updateGrocery(Long id, GroceryItem groceryItem) {
		GroceryItem existingItem = groceryItemRepository.findById(id)
				.orElseThrow(() -> new GroceryIdNotFoundException("GroceryItem not found for this id :: " + id));
		existingItem.setName(groceryItem.getName());
		existingItem.setPrice(groceryItem.getPrice());
		existingItem.setInventory(groceryItem.getInventory());
		return groceryItemRepository.save(existingItem);
	}

	// Service Method For Updating Inventory Of Grocery
	
	public GroceryItem updateInventory(Long id, int inventory) {
		GroceryItem existingItem = groceryItemRepository.findById(id)
				.orElseThrow(() -> new GroceryIdNotFoundException("GroceryItem not found for this id :: " + id));
		existingItem.setInventory(inventory);
		return groceryItemRepository.save(existingItem);
	}
}
