package com.scm.Supply.chain.apis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Order;
import com.scm.Supply.chain.apis.Entity.Shipping;
import com.scm.Supply.chain.apis.Service.ShippingService;

@RestController
@RequestMapping("/orders/shipping")
public class ShippingController {

	private final ShippingService shippingService;
	
	@Autowired
	public ShippingController(ShippingService shippingService) {
		this.shippingService = shippingService;
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Shipping> getShippingDetails(@PathVariable Long orderId){
		Order order = getOrderById(orderId);
		Shipping shippingDetails = shippingService.getShippingDetails(order);
		return ResponseEntity.ok(shippingDetails);
	}
	
	@PutMapping("/{orderId}/status")
	    public ResponseEntity<Void> updateShippingStatus(@PathVariable Long orderId, String newStatus) {
	        Order order = getOrderById(orderId); 
	        shippingService.updateShippingStatus(order, newStatus);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	
	 private Order getOrderById(Long orderId) {
	        return new Order(orderId);
	    } 
}
