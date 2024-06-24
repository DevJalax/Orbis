package com.scm.Supply.chain.apis.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.DTO.AccountType;
import com.scm.Supply.chain.apis.Entity.FinancialRecord;
import com.scm.Supply.chain.apis.Service.FinancialManagementService;

@RestController
@RequestMapping("/api/financial-management")
public class FinancialManagementController {
	
    private final FinancialManagementService service;

    @Autowired
    public FinancialManagementController(FinancialManagementService service) {
        this.service = service;
    }

    @GetMapping
    public List<FinancialRecord> getAllFinancialRecords() {
        return service.getAllFinancialRecords();
    }

    @GetMapping("/account-type/{accountType}")
    public List<FinancialRecord> getFinancialRecordsByAccountType(@PathVariable AccountType accountType) {
        return service.getFinancialRecordsByAccountType(accountType);
    }

    @GetMapping("/transaction-date/{transactionDate}")
    public List<FinancialRecord> getFinancialRecordsByTransactionDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate transactionDate) {
        return service.getFinancialRecordsByTransactionDate(transactionDate);
    }

    @GetMapping("/amount/{amount}")
    public List<FinancialRecord> getFinancialRecordsByAmount(@PathVariable BigDecimal amount) {
        return service.getFinancialRecordsByAmount(amount);
    }

    @PostMapping
    public FinancialRecord createFinancialRecord(@RequestBody FinancialRecord record) {
        return service.createFinancialRecord(record);
    }

    @PutMapping("/{id}")
    public FinancialRecord updateFinancialRecord(@PathVariable Long id, @RequestBody FinancialRecord record) throws Exception {
        return service.updateFinancialRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteFinancialRecord(@PathVariable Long id) throws Exception {
        service.deleteFinancialRecord(id);
    }
}
