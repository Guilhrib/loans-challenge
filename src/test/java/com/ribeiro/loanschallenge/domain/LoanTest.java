package com.ribeiro.loanschallenge.domain;

import com.ribeiro.loanschallenge.domain.enums.LoanType;
import com.ribeiro.loanschallenge.domain.exception.LoanNotAvailableException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanTest {
    @Mock
    private Costumer costumer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqual3K() {
            doReturn(true).when(costumer).isIncomeEqualOrLowerThan(3000);
            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLowerThan30AndLocationIsSP() {
            doReturn(false).when(costumer).isIncomeEqualOrLowerThan(3000);
            doReturn(true).when(costumer).isIncomeBetween(3000, 5000);
            doReturn(true).when(costumer).isAgeLowerThan(30);
            doReturn(true).when(costumer).isFromLocation("SP");
            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqual3K() {
            doReturn(true).when(costumer).isIncomeEqualOrLowerThan(3000);
            assertTrue(loan.isGuaranteedAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLowerThan30AndLocationIsSP() {
            doReturn(false).when(costumer).isIncomeEqualOrLowerThan(3000);
            doReturn(true).when(costumer).isIncomeBetween(3000, 5000);
            doReturn(true).when(costumer).isAgeLowerThan(30);
            doReturn(true).when(costumer).isFromLocation("SP");
            assertTrue(loan.isGuaranteedAvailable());
        }
    }

    @Nested
    class isConsignmentAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5k() {
            doReturn(true).when(costumer).isIncomeEqualOrGreaterThan(5000);
            assertTrue(loan.isConsignmentAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsLowerThan5k() {
            doReturn(false).when(costumer).isIncomeEqualOrGreaterThan(5000);
            assertFalse(loan.isConsignmentAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {
        @Test
        void shouldBeTheRightValueWhenTheLoanIsAvailable() {
            doReturn(true).when(costumer).isIncomeEqualOrLowerThan(3000);
            assertEquals(LoanType.PERSONAL.getValue(), loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowWhenPersonalLoanIsNotAvailable() {
            doReturn(false).when(costumer).isIncomeEqualOrLowerThan(3000);
            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate {
        @Test
        void shouldBeTheRightValueWhenTheLoanIsAvailable() {
            doReturn(true).when(costumer).isIncomeEqualOrLowerThan(3000);
            assertEquals(LoanType.GUARANTEED.getValue(), loan.getGuaranteedLoanInterestRate());
        }

        @Test
        void shouldThrowWhenGuaranteedLoanIsNotAvailable() {
            doReturn(false).when(costumer).isIncomeEqualOrLowerThan(3000);
            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsignmentLoanInterestRate {
        @Test
        void shouldBeTheRightValueWhenTheLoanIsAvailable() {
            doReturn(true).when(costumer).isIncomeEqualOrGreaterThan(5000);
            assertEquals(LoanType.CONSIGNMENT.getValue(), loan.getConsignmentLoanInterestRate());
        }

        @Test
        void shouldThrowWhenConsignmentLoanIsNotAvailable() {
            doReturn(false).when(costumer).isIncomeEqualOrGreaterThan(5000);
            assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInterestRate());
        }
    }
}