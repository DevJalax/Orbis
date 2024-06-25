package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Dispensing;
import com.scm.Supply.chain.apis.Service.DispensingService;

@RestController
@RequestMapping("/api/dispensings")
public class DispensingController {
	
    private final DispensingService dispensingService;

    @Autowired
    public DispensingController(DispensingService dispensingService) {
        this.dispensingService = dispensingService;
    }

    @GetMapping
    public List<Dispensing> getAllDispensings() {
        return dispensingService.getAllDispensings();
    }

    @GetMapping("/{id}")
    public Dispensing getDispensingById(@PathVariable Long id) throws Exception {
        return dispensingService.getDispensingById(id);
    }

    @PostMapping
    public Dispensing dispense(@RequestParam Long prescriptionId, @RequestParam Long drugId, @RequestParam int quantity) throws Exception {
        return dispensingService.dispense(prescriptionId, drugId, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteDispensing(@PathVariable Long id) {
        dispensingService.deleteDispensing(id);
    }
}
