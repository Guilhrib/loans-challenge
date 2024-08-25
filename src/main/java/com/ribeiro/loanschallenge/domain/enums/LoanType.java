package com.ribeiro.loanschallenge.domain.enums;

import lombok.Getter;

@Getter
public enum LoanType {
    PERSONAL(4.0),
    GUARANTEED(2.0),
    CONSIGNMENT(3.0);

    private final double value;

    LoanType(double value) {
        this.value = value;
    }
}
