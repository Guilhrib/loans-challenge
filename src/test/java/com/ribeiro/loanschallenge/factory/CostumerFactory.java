package com.ribeiro.loanschallenge.factory;

import com.ribeiro.loanschallenge.domain.Costumer;

public class CostumerFactory {
    public static Costumer build(int age, String document, String name, double income, String location) {
        return new Costumer(age, document, name, income, location);
    }

    public static Costumer build() {
        return build(25, "123.123.123-12", "Costumer", 5000.0, "SP");
    }

    public static Costumer build(double income) {
        return build(25, "123.123.123-12", "Costumer", income, "SP");
    }

    public static Costumer build(int age) {
        return build(age, "123.123.123-12", "Costumer", 5000.0, "SP");
    }

    public static Costumer build(String location) {
        return build(25, "123.123.123-12", "Costumer", 5000.0, location);
    }
}
