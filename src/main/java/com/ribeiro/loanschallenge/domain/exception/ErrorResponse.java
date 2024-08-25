package com.ribeiro.loanschallenge.domain.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String message,
        int code,
        HttpStatus statusCode
) {
}
