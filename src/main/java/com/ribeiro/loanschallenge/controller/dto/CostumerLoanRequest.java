package com.ribeiro.loanschallenge.controller.dto;

import com.ribeiro.loanschallenge.domain.Costumer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CostumerLoanRequest(
        @NotNull
        @Min(value = 18)
        Integer age,
        @CPF
        String cpf,
        @NotBlank
        String name,
        @NotNull
        @Min(value = 1000)
        Double income,
        @NotBlank
        String location
) {
    public Costumer toCostumer() {
        return new Costumer(
                age,
                cpf,
                name,
                income,
                location
        );
    }
}
