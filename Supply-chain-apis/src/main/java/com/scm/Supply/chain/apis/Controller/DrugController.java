package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Drug;
import com.scm.Supply.chain.apis.Service.DrugService;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {
	
    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("/{id}")
    public Drug getDrugById(@PathVariable Long id) throws Exception {
        return drugService.getDrugById(id);
    }

    @PostMapping
    public Drug saveDrug(@RequestBody Drug drug) {
        return drugService.saveDrug(drug);
    }

    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable Long id) {
        drugService.deleteDrug(id);
    }
}
