package com.ribeiro.loanschallenge.service;

import com.ribeiro.loanschallenge.controller.dto.CostumerLoanRequest;
import com.ribeiro.loanschallenge.controller.dto.CostumerLoanResponse;

public interface LoanService {
    CostumerLoanResponse checkLoanAvailability(CostumerLoanRequest request);
}
