package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Drug;
import com.scm.Supply.chain.apis.Repo.DrugRepository;

@Service
public class DrugService {
	
    private final DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    public Drug getDrugById(Long id) throws Exception {
        return drugRepository.findById(id).orElseThrow(() -> new Exception("Drug not found"));
    }

    public Drug saveDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public void deleteDrug(Long id) {
        drugRepository.deleteById(id);
    }
}
