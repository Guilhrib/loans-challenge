package com.ribeiro.loanschallenge.controller;

import com.ribeiro.loanschallenge.controller.dto.CostumerLoanRequest;
import com.ribeiro.loanschallenge.controller.dto.CostumerLoanResponse;
import com.ribeiro.loanschallenge.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping(value = "/costumer-loans")
    public ResponseEntity<CostumerLoanResponse> costumerLoan(@RequestBody @Valid CostumerLoanRequest request) {
        var response = loanService.checkLoanAvailability(request);
        return ResponseEntity.ok().body(response);
    }
}
