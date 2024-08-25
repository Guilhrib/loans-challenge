package com.ribeiro.loanschallenge.domain;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Costumer {
    private final Integer age;
    private final String cpf;
    private final String name;
    private final Double income;
    private final String location;

    public boolean isIncomeEqualOrLowerThan(double value) {
        return this.income <= value;
    }

    public boolean isIncomeBetween(double minValue, double maxValue) {
        return this.income >= minValue && this.income <= maxValue;
    }

    public boolean isIncomeEqualOrGreaterThan(double value) {
        return this.income >= value;
    }

    public boolean isAgeLowerThan(int value) {
        return this.age < value;
    }

    public boolean isFromLocation(String location) {
        return this.location.equals(location);
    }
}
