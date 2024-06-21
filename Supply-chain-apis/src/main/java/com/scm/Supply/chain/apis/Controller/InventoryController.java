package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Inventory;
import com.scm.Supply.chain.apis.Repo.InventoryRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	private final InventoryRepository inventoryRepository;
	
	    @Autowired
	    public InventoryController(InventoryRepository inventoryRepository) {
	        this.inventoryRepository = inventoryRepository;
	    }
	
	    @GetMapping
	    public List<Inventory> getAllProducts() {
	        return inventoryRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Inventory getProductById(@PathVariable Long id) {
	        return inventoryRepository.findById(id).orElse(null);
	    }
	    
	    @PostMapping
	    public Inventory createProduct(@RequestBody Inventory inventory) {
	        return inventoryRepository.save(inventory);
	    }

	    @PutMapping
	    public Inventory updateProduct(@PathVariable Long id , @RequestBody Inventory inventory) {
	    
	    	Inventory existingProduct = inventoryRepository.findById(id).orElse(null);
	    	existingProduct.setQuantity(inventory.getQuantity());
	    	return inventoryRepository.save(existingProduct);
	    }
}
