package com.scm.Supply.chain.apis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Asset;
import com.scm.Supply.chain.apis.Entity.MaintenanceRecord;
import com.scm.Supply.chain.apis.Entity.Product;
import com.scm.Supply.chain.apis.Entity.ProductionOrder;
import com.scm.Supply.chain.apis.Entity.QualityInspection;
import com.scm.Supply.chain.apis.Service.ProductionManagementService;

@RestController
@RequestMapping("/api/production")
public class ProductionManagementController {
	
    private final ProductionManagementService productionManagementService;

    @Autowired
    public ProductionManagementController(ProductionManagementService productionManagementService) {
        this.productionManagementService = productionManagementService;
    }

    // Production Planning and Control
    @PostMapping("/orders")
    public ProductionOrder createProductionOrder(@RequestBody ProductionOrder productionOrder) {
        return productionManagementService.createProductionOrder(productionOrder);
    }

    // Quality Management
    @PostMapping("/inspections")
    public QualityInspection createQualityInspection(@RequestBody QualityInspection qualityInspection) {
        return productionManagementService.createQualityInspection(qualityInspection);
    }

    // Maintenance and Asset Management
    @PostMapping("/assets")
    public Asset createAsset(@RequestBody Asset asset) {
        return productionManagementService.createAsset(asset);
    }

    @PostMapping("/maintenance")
    public MaintenanceRecord createMaintenanceRecord(@RequestBody MaintenanceRecord maintenanceRecord) {
        return productionManagementService.createMaintenanceRecord(maintenanceRecord);
    }

    // Product Costing and Pricing
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productionManagementService.createProduct(product);
    }

    @PutMapping("/products/{id}/price")
    public Product updateProductPrice(@PathVariable Long id, @RequestParam double newPrice) throws Exception {
        return productionManagementService.updateProductPrice(id, newPrice);
    }
}
