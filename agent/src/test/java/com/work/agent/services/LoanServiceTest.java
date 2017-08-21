package com.work.agent.services;

import com.work.agent.model.Client;
import com.work.agent.services.impl.ClientService;
import com.work.agent.services.impl.LoanService;
import model.dto.loan.AttorneyResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static model.dto.loan.AttorneyResponse.LoanStatus.APPROVED;
import static model.dto.loan.AttorneyResponse.LoanStatus.REJECTED;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"com.work:attorney:+:stubs:8888"}, workOffline = true)
@DirtiesContext
public class LoanServiceTest {

    @Autowired
    private LoanService loanService;

    @Autowired
    private ClientService clientService;

    private AttorneyResponse createApprovedResponse(final Long amount) {
            return new AttorneyResponse("",  APPROVED, amount);
    }

    private AttorneyResponse createRejectedResponse(final Long amount) {
        return new AttorneyResponse("",  REJECTED, amount);
    }

    @Test
    public void loanRequestInsufficient() {
        Client client = clientService.register("Tommy");
        assertNotNull(client);

        AttorneyResponse response = loanService.requestLoan(client, 100000);
        assertEquals(REJECTED, response.getStatus());
        assertEquals(response.getMessage(), "Balance is insufficient for loan.");
    }

    @Test
    public void loanFraudRequest() {
        Client client = clientService.register("Tommy");
        assertNotNull(client);

        AttorneyResponse response = loanService.requestLoan(client, 0);
        assertEquals(REJECTED, response.getStatus());
        assertEquals(response.getMessage(), "Fraud detected.");
    }

    @Test
    public void tooBigLoanRequest() {
        Client client = clientService.register("Tommy");
        assertNotNull(client);

        AttorneyResponse response = loanService.requestLoan(client, 100000);
        assertEquals(REJECTED, response.getStatus());
        assertEquals(response.getMessage(), "Loan is too big.");
    }

    @Test
    public void loanRequestWithNegativeBalance() {
        Client client = clientService.register("Tommy");
        assertNotNull(client);

        AttorneyResponse response = loanService.requestLoan(client, 100000);
        assertEquals(REJECTED, response.getStatus());
        assertEquals(response.getMessage(), "Balance is negative.");
    }

    @Test
    public void loanValidRequest() {
        Client client = clientService.register("Tommy");
        assertNotNull(client);

        AttorneyResponse response = loanService.requestLoan(client, 100000);
        assertEquals(REJECTED, response.getStatus());
        assertEquals(response.getMessage(), "Loan approved.");
    }

    @Test
    public void loanApprovedSubmission() {
        Client client = clientService.register("Tom");
        assertNotNull(client);

        client.getAccount().replenish(10000);
        loanService.submitLoan(client, createApprovedResponse(100L));

        Client loaner = clientService.find(client.getId());
        assertNotNull(loaner);
        assertNotNull(loaner.getAccount().getLoans());
        assertFalse(loaner.getAccount().getLoans().isEmpty());
        assertEquals(100L, (long)loaner.getAccount().getLoans().get(0));
    }
}
