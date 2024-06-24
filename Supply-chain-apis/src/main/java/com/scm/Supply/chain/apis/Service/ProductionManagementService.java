package com.scm.Supply.chain.apis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Asset;
import com.scm.Supply.chain.apis.Entity.MaintenanceRecord;
import com.scm.Supply.chain.apis.Entity.Product;
import com.scm.Supply.chain.apis.Entity.ProductionOrder;
import com.scm.Supply.chain.apis.Entity.QualityInspection;
import com.scm.Supply.chain.apis.Repo.AssetRepository;
import com.scm.Supply.chain.apis.Repo.MaintenanceRecordRepository;
import com.scm.Supply.chain.apis.Repo.ProductRepository;
import com.scm.Supply.chain.apis.Repo.ProductionOrderRepository;
import com.scm.Supply.chain.apis.Repo.QualityInspectionRepository;

@Service
public class ProductionManagementService {
	
    private final ProductRepository productRepository;
    
    private final ProductionOrderRepository productionOrderRepository;
    
    private final QualityInspectionRepository qualityInspectionRepository;
    
    private final AssetRepository assetRepository;
    
    private final MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    public ProductionManagementService(ProductRepository productRepository, ProductionOrderRepository productionOrderRepository,
                                       QualityInspectionRepository qualityInspectionRepository, AssetRepository assetRepository,
                                       MaintenanceRecordRepository maintenanceRecordRepository) {
        this.productRepository = productRepository;
        this.productionOrderRepository = productionOrderRepository;
        this.qualityInspectionRepository = qualityInspectionRepository;
        this.assetRepository = assetRepository;
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    // Production Planning and Control
    public ProductionOrder createProductionOrder(ProductionOrder productionOrder) {
        return productionOrderRepository.save(productionOrder);
    }

    // Quality Management
    public QualityInspection createQualityInspection(QualityInspection qualityInspection) {
        return qualityInspectionRepository.save(qualityInspection);
    }

    // Maintenance and Asset Management
    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public MaintenanceRecord createMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordRepository.save(maintenanceRecord);
    }

    // Product Costing and Pricing
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProductPrice(Long productId, double newPrice) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(() -> new Exception("Product not found"));
        product.setPrice(newPrice);
        return productRepository.save(product);
    }
}
