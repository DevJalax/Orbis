package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Investment;
import com.scm.Supply.chain.apis.Repo.InvestmentRepository;

@Service
public class InvestmentService {
	
    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public Investment createInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Investment getInvestmentById(Long id) throws Exception {
        return investmentRepository.findById(id)
                .orElseThrow(() -> new Exception("Investment not found with id: " + id));
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Investment updateInvestment(Long id, Investment updatedInvestment) throws Exception {
        Investment investment = getInvestmentById(id);
        investment.setName(updatedInvestment.getName());
        investment.setAmount(updatedInvestment.getAmount());
        investment.setInvestmentDate(updatedInvestment.getInvestmentDate());
        investment.setMaturityDate(updatedInvestment.getMaturityDate());
        investment.setInterestRate(updatedInvestment.getInterestRate());
        return investmentRepository.save(investment);
    }

    public void deleteInvestment(Long id) throws Exception {
        Investment investment = getInvestmentById(id);
        investmentRepository.delete(investment);
    }
}
