package com.ribeiro.loanschallenge.controller.dto;

import java.util.List;

public record CostumerLoanResponse(
        String costumer,
        List<LoanResponse> loans
) {
}
