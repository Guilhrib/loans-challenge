package com.ribeiro.loanschallenge.controller.dto;

import com.ribeiro.loanschallenge.domain.enums.LoanType;

public record LoanResponse(
    LoanType type,
    Double interestRate
) {
}
