package com.ribeiro.loanschallenge.domain.exception;

public class LoanNotAvailableException extends RuntimeException {
    public LoanNotAvailableException() {
        super("loan is not available to this costumer");
    }
}
