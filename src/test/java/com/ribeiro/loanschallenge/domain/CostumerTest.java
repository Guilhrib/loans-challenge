package com.ribeiro.loanschallenge.domain;

import com.ribeiro.loanschallenge.factory.CostumerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostumerTest {
    @Nested
    class isIncomeEqualOrLowerThan {
        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThanValue() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrLowerThan(9000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThanValue() {
            var costumer = CostumerFactory.build(5000.0);
            assertFalse(costumer.isIncomeEqualOrLowerThan(3000.0));
        }
    }

    @Nested
    class isIncomeBetween {
        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeBetween(3000.0, 7000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualMin() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeBetween(5000.0, 6000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualMax() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeBetween(4000.0, 5000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {
            var costumer = CostumerFactory.build(5000.0);
            assertFalse(costumer.isIncomeBetween(6000.0, 7000.0));
        }
    }

    @Nested
    class isIncomeEqualOrGreaterThan {
        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrGreaterThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThanValue() {
            var costumer = CostumerFactory.build(5000.0);
            assertTrue(costumer.isIncomeEqualOrGreaterThan(3000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {
            var costumer = CostumerFactory.build(5000.0);
            assertFalse(costumer.isIncomeEqualOrGreaterThan(7000.0));
        }
    }

    @Nested
    class isAgeLowerThan {
        @Test
        void shouldBeTrueWhenAgeIsLowerThanValue() {
            var costumer = CostumerFactory.build(25);
            assertTrue(costumer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsGreaterThanValue() {
            var costumer = CostumerFactory.build(25);
            assertFalse(costumer.isAgeLowerThan(20));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualThanValue() {
            var costumer = CostumerFactory.build(25);
            assertFalse(costumer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {
        @Test
        void shouldBeTrueWhenLocationIsEqual() {
            var costumer = CostumerFactory.build("SP");
            assertTrue(costumer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsDifferent() {
            var costumer = CostumerFactory.build("SP");
            assertFalse(costumer.isFromLocation("RJ"));
        }

        @Test
        void shouldBeFalseWhenValueIsEmpty() {
            var costumer = CostumerFactory.build("SP");
            assertFalse(costumer.isFromLocation(""));
        }

        @Test
        void shouldBeFalseWhenValueIsNull() {
            var costumer = CostumerFactory.build("SP");
            assertFalse(costumer.isFromLocation(null));
        }
    }
}