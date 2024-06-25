package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Drug;
import com.scm.Supply.chain.apis.Entity.Prescription;
import com.scm.Supply.chain.apis.Entity.PrescriptionItem;
import com.scm.Supply.chain.apis.Repo.PrescriptionRepository;

@Service
public class PrescriptionService {
	
    private final PrescriptionRepository prescriptionRepository;
    
    private final DrugService drugService;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, DrugService drugService) {
        this.prescriptionRepository = prescriptionRepository;
        this.drugService = drugService;
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(Long id) throws Exception {
        return prescriptionRepository.findById(id).orElseThrow(() -> new Exception("Prescription not found"));
    }

    public Prescription savePrescription(Prescription prescription) throws Exception {
        List<PrescriptionItem> prescriptionItems = prescription.getPrescriptionItems();
        for (PrescriptionItem item : prescriptionItems) {
            Drug drug = drugService.getDrugById(item.getDrug().getId());
            if (drug.getQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Insufficient drug quantity for " + drug.getName());
            }
            drug.setQuantity(drug.getQuantity() - item.getQuantity());
            drugService.saveDrug(drug);
        }
        return prescriptionRepository.save(prescription);
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}

