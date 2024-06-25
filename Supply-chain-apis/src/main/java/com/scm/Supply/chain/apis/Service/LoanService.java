package com.scm.Supply.chain.apis.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.DTO.LoanRequest;
import com.scm.Supply.chain.apis.DTO.LoanStatus;
import com.scm.Supply.chain.apis.Entity.Customer;
import com.scm.Supply.chain.apis.Entity.Loan;
import com.scm.Supply.chain.apis.Repo.LoanRepository;

@Service
public class LoanService {
	
    private final LoanRepository loanRepository;
    
    private final CustomerService customerService;

    @Autowired
    public LoanService(LoanRepository loanRepository, CustomerService customerService) {
        this.loanRepository = loanRepository;
        this.customerService = customerService;
    }

    public Loan createLoan(LoanRequest loanRequest) {
        Customer customer = customerService.getCustomerById(loanRequest.getCustomerId());
        Loan loan = new Loan();
        loan.setLoanNumber(generateLoanNumber());
        loan.setLoanAmount(loanRequest.getLoanAmount());
        loan.setLoanDate(loanRequest.getLoanDate());
        loan.setDueDate(loanRequest.getDueDate());
        loan.setInterestRate(loanRequest.getInterestRate());
        loan.setMonthlyPayment(calculateMonthlyPayment(loanRequest.getLoanAmount(), loanRequest.getInterestRate(), loanRequest.getDueDate()));
        loan.setStatus(LoanStatus.PENDING);
        loan.setCustomer(customer);
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public List<Loan> getCustomerLoans(Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return loanRepository.findByCustomer(customer);
    }

    public Loan approveLoan(Long loanId) throws Exception {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new Exception("Loan not found"));
        loan.setStatus(LoanStatus.APPROVED);
        return loanRepository.save(loan);
    }

    public Loan rejectLoan(Long loanId) throws Exception {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new Exception("Loan not found"));
        loan.setStatus(LoanStatus.REJECTED);
        return loanRepository.save(loan);
    }

    private String generateLoanNumber() {
        // Generate a unique loan number
        return "LOAN-" + UUID.randomUUID().toString().substring(0, 8);
    }

    private BigDecimal calculateMonthlyPayment(BigDecimal loanAmount, BigDecimal interestRate, LocalDate dueDate) {
        // Calculate the monthly payment based on the loan amount, interest rate, and due date
        // You can use a formula like the one below or a more complex calculation
        int numMonths = (int) ChronoUnit.MONTHS.between(LocalDate.now(), dueDate);
        BigDecimal monthlyInterestRate = interestRate.divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP);
        return loanAmount.multiply(monthlyInterestRate.divide(BigDecimal.ONE.subtract(BigDecimal.ONE.add(monthlyInterestRate).pow(-numMonths)), 2, RoundingMode.HALF_UP));
    }
}
