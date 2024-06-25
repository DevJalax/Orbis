package com.scm.Supply.chain.apis.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Dispensing;
import com.scm.Supply.chain.apis.Entity.Drug;
import com.scm.Supply.chain.apis.Entity.Prescription;
import com.scm.Supply.chain.apis.Repo.DispensingRepository;

@Service
public class DispensingService {
	
    private final DispensingRepository dispensingRepository;
    
    private final PrescriptionService prescriptionService;
    
    private final DrugService drugService;

    public DispensingService(DispensingRepository dispensingRepository, PrescriptionService prescriptionService, DrugService drugService) {
        this.dispensingRepository = dispensingRepository;
        this.prescriptionService = prescriptionService;
        this.drugService = drugService;
    }

    public List<Dispensing> getAllDispensings() {
        return dispensingRepository.findAll();
    }

    public Dispensing getDispensingById(Long id) throws Exception {
        return dispensingRepository.findById(id).orElseThrow(() -> new Exception("Dispensing not found"));
    }

    public Dispensing dispense(Long prescriptionId, Long drugId, int quantity) throws Exception {
        Prescription prescription = prescriptionService.getPrescriptionById(prescriptionId);
        Drug drug = drugService.getDrugById(drugId);
        if (drug.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient drug quantity for " + drug.getName());
        }
        drug.setQuantity(drug.getQuantity() - quantity);
        drugService.saveDrug(drug);
        Dispensing dispensing = new Dispensing();
        dispensing.setPrescription(prescription);
        dispensing.setDrug(drug);
        dispensing.setQuantity(quantity);
        dispensing.setDispensedDate(LocalDate.now());
        return dispensingRepository.save(dispensing);
    }

    public void deleteDispensing(Long id) {
        dispensingRepository.deleteById(id);
    }
}
