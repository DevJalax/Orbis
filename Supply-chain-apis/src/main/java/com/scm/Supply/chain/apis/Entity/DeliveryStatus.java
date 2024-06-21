package com.scm.Supply.chain.apis.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="delivery_status")
public class DeliveryStatus {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String orderOrShipmentId;
    private String status;
    private double latitude;
    private double longitude;

    public DeliveryStatus(String orderOrShipmentId, String status, double latitude, double longitude) {
        this.orderOrShipmentId = orderOrShipmentId;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderOrShipmentId() {
		return orderOrShipmentId;
	}

	public void setOrderOrShipmentId(String orderOrShipmentId) {
		this.orderOrShipmentId = orderOrShipmentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
