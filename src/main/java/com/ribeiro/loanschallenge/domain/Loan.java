package com.ribeiro.loanschallenge.domain;

import com.ribeiro.loanschallenge.domain.enums.LoanType;
import com.ribeiro.loanschallenge.domain.exception.LoanNotAvailableException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Loan {
    private final Costumer costumer;

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public boolean isConsignmentAvailable() {
        return costumer.isIncomeEqualOrGreaterThan(5000.0);
    }

    public boolean isGuaranteedAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if(isPersonalLoanAvailable()) {
            return LoanType.PERSONAL.getValue();
        }
        throw new LoanNotAvailableException();
    }

    public double getConsignmentLoanInterestRate() {
        if(isConsignmentAvailable()) {
            return LoanType.CONSIGNMENT.getValue();
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate() {
        if(isGuaranteedAvailable()) {
            return LoanType.GUARANTEED.getValue();
        }
        throw new LoanNotAvailableException();
    }

    private boolean basicLoanAvailable() {
        if(costumer.isIncomeEqualOrLowerThan(3000.0)) {
            return true;
        }

        return costumer.isIncomeBetween(3000.0, 5000.0)
                && costumer.isAgeLowerThan(30)
                && costumer.isFromLocation("SP");
    }
}
