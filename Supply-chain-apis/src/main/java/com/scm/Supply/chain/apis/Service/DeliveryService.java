package com.scm.Supply.chain.apis.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.DeliveryStatus;

@Service
public class DeliveryService {

	private Map<String, DeliveryStatus> deliveryStatuses = new HashMap<>();

    public DeliveryStatus getDeliveryStatus(String orderOrShipmentId) {
        // Retrieve delivery status from database or other source
        DeliveryStatus status = deliveryStatuses.get(orderOrShipmentId);
        if (status == null) {
            status = new DeliveryStatus(orderOrShipmentId, "Pending", 0.0, 0.0);
            deliveryStatuses.put(orderOrShipmentId, status);
        }
        return status;
    }

    public void updateDeliveryStatus(String orderOrShipmentId, double latitude, double longitude) {
        DeliveryStatus status = deliveryStatuses.get(orderOrShipmentId);
        if (status != null) {
            status.setLatitude(latitude);
            status.setLongitude(longitude);
            status.setStatus("In Transit");
            deliveryStatuses.put(orderOrShipmentId, status);
        }
    }
	
}
