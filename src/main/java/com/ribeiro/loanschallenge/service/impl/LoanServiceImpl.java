package com.ribeiro.loanschallenge.service.impl;

import com.ribeiro.loanschallenge.controller.dto.CostumerLoanRequest;
import com.ribeiro.loanschallenge.controller.dto.CostumerLoanResponse;
import com.ribeiro.loanschallenge.controller.dto.LoanResponse;
import com.ribeiro.loanschallenge.domain.Loan;
import com.ribeiro.loanschallenge.domain.enums.LoanType;
import com.ribeiro.loanschallenge.service.LoanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Override
    public CostumerLoanResponse checkLoanAvailability(CostumerLoanRequest request) {
        var costumer = request.toCostumer();
        var loan = new Loan(costumer);

        List<LoanResponse> loans = new ArrayList<>();
        if(loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if(loan.isConsignmentAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if(loan.isGuaranteedAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CostumerLoanResponse(request.name(), loans);
    }
}
