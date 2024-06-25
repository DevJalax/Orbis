package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.DTO.LoanRequest;
import com.scm.Supply.chain.apis.Entity.Loan;
import com.scm.Supply.chain.apis.Service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
	
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody LoanRequest loanRequest) {
        Loan loan = loanService.createLoan(loanRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Loan>> getCustomerLoans(@PathVariable Long customerId) {
        List<Loan> loans = loanService.getCustomerLoans(customerId);
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/{loanId}/approve")
    public ResponseEntity<Loan> approveLoan(@PathVariable Long loanId) throws Exception {
        Loan loan = loanService.approveLoan(loanId);
        return ResponseEntity.ok(loan);
    }

    @PutMapping("/{loanId}/reject")
    public ResponseEntity<Loan> rejectLoan(@PathVariable Long loanId) throws Exception {
        Loan loan = loanService.rejectLoan(loanId);
        return ResponseEntity.ok(loan);
    }
}
