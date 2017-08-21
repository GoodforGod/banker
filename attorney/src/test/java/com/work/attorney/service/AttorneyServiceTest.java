package com.work.attorney.service;

import com.work.attorney.model.states.LoanVerdict;
import com.work.attorney.services.impl.AttorneyService;
import model.dto.loan.AttorneyResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttorneyServiceTest {

    @Autowired
    private AttorneyService attorneyService;

    @Test
    public void isBalanceInsufficient() {
        LoanVerdict verdict = attorneyService.verify(10, 1000);
        AttorneyResponse res = new AttorneyResponse();

        assertEquals(verdict, LoanVerdict.BALANCE_INSUFFICIENT);
    }

    @Test
    public void isBalanceNegative() {
        LoanVerdict verdict = attorneyService.verify(-1, 100);

        assertEquals(verdict, LoanVerdict.BALANCE_NEGATIVE);
    }

    @Test
    public void isLoanHuge() {
        LoanVerdict verdict = attorneyService.verify(1000000, 100000);

        assertEquals(verdict, LoanVerdict.LOAN_HUGE);
    }

    @Test
    public void isLoanApproved() {
        LoanVerdict verdict = attorneyService.verify(100000, 1000);

        assertEquals(verdict, LoanVerdict.LOAN_APPROVED);
    }
}
