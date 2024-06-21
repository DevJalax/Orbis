package com.scm.Supply.chain.apis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.DeliveryStatus;
import com.scm.Supply.chain.apis.Service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
    private DeliveryService deliveryService;

    @GetMapping("/track/{orderOrShipmentId}")
    public ResponseEntity<DeliveryStatus> trackDelivery(@PathVariable String orderOrShipmentId) {
        DeliveryStatus status = deliveryService.getDeliveryStatus(orderOrShipmentId);
        return ResponseEntity.ok(status);
    }
	
}
