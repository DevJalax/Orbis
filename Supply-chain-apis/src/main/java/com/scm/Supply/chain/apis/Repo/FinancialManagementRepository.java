package com.scm.Supply.chain.apis.Repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.DTO.AccountType;
import com.scm.Supply.chain.apis.Entity.FinancialRecord;

@Repository
public interface FinancialManagementRepository extends JpaRepository<FinancialRecord, Long> {
    List<FinancialRecord> findByAccountType(AccountType accountType);
    List<FinancialRecord> findByTransactionDate(LocalDate transactionDate);
    List<FinancialRecord> findByAmount(BigDecimal amount);
}
