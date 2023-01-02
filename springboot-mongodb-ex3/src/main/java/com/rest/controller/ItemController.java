package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.GroceryItem;
import com.rest.repository.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	ItemRepository groceryItemRepo;

	@PostMapping("/addItem")
	public String addItem(@RequestBody GroceryItem groceryItem) {
		groceryItemRepo.save(groceryItem);
		return "Added groceryItem with id : " + groceryItem.getId();
	}

	// 1. Show all the data
	@GetMapping("/findAllItems")
	public List<GroceryItem> getGroceryItems() {
		return groceryItemRepo.findAll();
	}

	// 2. Get item by name
	@GetMapping("itemByName/{name}")
	public GroceryItem getGroceryItemByName(@PathVariable String name) {
		System.out.println("Getting item by name: " + name);
		return groceryItemRepo.findItemByName(name);
	}

	// 3. Get name and quantity of a all items of a particular category
	@GetMapping("itemsByCategory/{category}")
	public List<GroceryItem> getItemsByCategory(@PathVariable String category) {
		System.out.println("Getting items for the category " + category);
		return groceryItemRepo.findAllByCategory(category);
	}

	// 4. Get count of documents in the collection
	@GetMapping("findAllItems/count")
	public long findCountOfGroceryItems() {
		long count = groceryItemRepo.count();
		System.out.println("Number of documents in the collection: " + count);
		return count;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteGroceryItem(@PathVariable String id) {
		groceryItemRepo.delete(id);
		System.out.println("Item with id " + id + " deleted...");
	}
	
	@PutMapping("/updateItem/{category}")
	public List<GroceryItem> updateCategoryName(@PathVariable String category) {
        
        // Change to this new value
        String newCategory = "munchies";
        
        // Find all the items with the category snacks
        List<GroceryItem> list = groceryItemRepo.findAllByCategory(category);
        
        list.forEach(item -> {
            // Update the category in each document
            item.setCategory(newCategory);
        });
        
        // Save all the items in database
        List<GroceryItem> itemsUpdated = groceryItemRepo.save(list);
        
        if(itemsUpdated != null)
            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
        
        return itemsUpdated;
    }
}
