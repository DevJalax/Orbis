package com.scm.Supply.chain.apis.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.DTO.AccountType;
import com.scm.Supply.chain.apis.Entity.FinancialRecord;
import com.scm.Supply.chain.apis.Repo.FinancialManagementRepository;

@Service
public class FinancialManagementService {
    private final FinancialManagementRepository repository;

    @Autowired
    public FinancialManagementService(FinancialManagementRepository repository) {
        this.repository = repository;
    }

    public List<FinancialRecord> getAllFinancialRecords() {
        return repository.findAll();
    }

    public List<FinancialRecord> getFinancialRecordsByAccountType(AccountType accountType) {
        return repository.findByAccountType(accountType);
    }

    public List<FinancialRecord> getFinancialRecordsByTransactionDate(LocalDate transactionDate) {
        return repository.findByTransactionDate(transactionDate);
    }

    public List<FinancialRecord> getFinancialRecordsByAmount(BigDecimal amount) {
        return repository.findByAmount(amount);
    }

    public FinancialRecord createFinancialRecord(FinancialRecord record) {
        return repository.save(record);
    }

    public FinancialRecord updateFinancialRecord(Long id, FinancialRecord record) throws Exception {
        FinancialRecord existingRecord = repository.findById(id)
                .orElseThrow(() -> new Exception("Financial record not found with id: " + id));
        existingRecord.setAccountType(record.getAccountType());
        existingRecord.setTransactionDate(record.getTransactionDate());
        existingRecord.setAmount(record.getAmount());
        existingRecord.setDescription(record.getDescription());
        return repository.save(existingRecord);
    }

    public void deleteFinancialRecord(Long id) throws Exception {
        FinancialRecord record = repository.findById(id)
                .orElseThrow(() -> new Exception("Financial record not found with id: " + id));
        repository.delete(record);
    }
}
