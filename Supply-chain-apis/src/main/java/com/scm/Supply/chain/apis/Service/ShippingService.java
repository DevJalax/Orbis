package com.scm.Supply.chain.apis.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Order;
import com.scm.Supply.chain.apis.Entity.Shipping;
import com.scm.Supply.chain.apis.Repo.ShippingRepository;

@Service
public class ShippingService {
	
	private final ShippingRepository shippingRepository; 
	
	@Autowired
	public ShippingService(ShippingRepository shippingRepository) {
		this.shippingRepository = shippingRepository;
	}

	  public Shipping getShippingDetails(Order order) {
	        // Fetch shipping details based on the order
	        Shipping shippingDetails = new Shipping();
	        shippingDetails.setOrder(order);
	        shippingDetails.setTrackingNumber(UUID.randomUUID().toString());
	        shippingDetails.setShippingMethod("Standard Delivery");
	        shippingDetails.setEstimatedDeliveryDate(null);
	        shippingDetails.setShippingStatus("Shipping soon");
	        return shippingDetails;
	    }
	
	  public void updateShippingStatus(Order order, String newStatus) {
	        // Update the shipping status for the order
	        Shipping shippingDetails = getShippingDetails(order);
	        shippingDetails.setShippingStatus(newStatus);
	        // Save the updated shipping details
	        shippingRepository.save(shippingDetails);
	    }
}
