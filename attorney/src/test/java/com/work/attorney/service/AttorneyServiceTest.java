package com.work.attorney.service;

import com.work.attorney.model.states.LoanVerdict;
import com.work.attorney.services.core.impl.AttorneyService;
import model.dto.loan.AttorneyResponse;
import model.dto.loan.LoanRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AttorneyServiceTest {

    @Autowired
    private AttorneyService attorneyService;

    @Test
    public void isBalanceInsufficient() {
        LoanVerdict verdict = attorneyService.verify(new LoanRequest(10, 1000));
        AttorneyResponse res = new AttorneyResponse();

        assertEquals(verdict, LoanVerdict.BALANCE_INSUFFICIENT);
    }

    @Test
    public void isBalanceNegative() {
        LoanVerdict verdict = attorneyService.verify(new LoanRequest(-1, 100));

        assertEquals(verdict, LoanVerdict.BALANCE_NEGATIVE);
    }

    @Test
    public void isLoanHuge() {
        LoanVerdict verdict = attorneyService.verify(new LoanRequest(1000000, 100000));

        assertEquals(verdict, LoanVerdict.LOAN_HUGE);
    }

    @Test
    public void isLoanApproved() {
        LoanVerdict verdict = attorneyService.verify(new LoanRequest(100000, 1000));

        assertEquals(verdict, LoanVerdict.LOAN_APPROVED);
    }
}
