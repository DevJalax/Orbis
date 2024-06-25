package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Investment;
import com.scm.Supply.chain.apis.Service.InvestmentService;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
	
    private final InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        Investment createdInvestment = investmentService.createInvestment(investment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvestment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) throws Exception {
        Investment investment = investmentService.getInvestmentById(id);
        return ResponseEntity.ok(investment);
    }

    @GetMapping
    public ResponseEntity<List<Investment>> getAllInvestments() {
        List<Investment> investments = investmentService.getAllInvestments();
        return ResponseEntity.ok(investments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investment) throws Exception {
        Investment updatedInvestment = investmentService.updateInvestment(id, investment);
        return ResponseEntity.ok(updatedInvestment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) throws Exception {
        investmentService.deleteInvestment(id);
        return ResponseEntity.noContent().build();
    }
}
