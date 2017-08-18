package com.work.agent.services;

import com.work.agent.model.AttorneyResponse;
import com.work.agent.model.Client;
import com.work.agent.services.impl.ClientService;
import com.work.agent.services.impl.LoanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static com.work.agent.model.AttorneyResponse.LoanStatus.REJECTED;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"com.work:attorney:+:stubs:8888"}, workOffline = true)
public class LoanServiceTest {

    @Autowired
    private LoanService loanService;

    @Autowired
    private ClientService clientService;

    @Test
    public void loanRequestSuccess() {
        Client client = clientService.register("Tommy");
        assertNotNull(client);

        AttorneyResponse response = loanService.requestLoan(client, 100000);
        assertEquals(REJECTED, response.getStatus());
        assertEquals(response.getMessage(), "Loan is too big.");
    }

    @Test
    public void loanSubmission() {
        Client client = clientService.register("Tom");
        assertNotNull(client);

        client.getAccount().replenish(10000);
        clientService.update(client);
        loanService.submitLoan(client, 100);

        Client loaner = clientService.find(client.getId());
        assertNotNull(loaner);
        assertNotNull(loaner.getAccount().getLoans());
        assertFalse(loaner.getAccount().getLoans().isEmpty());
        assertEquals(100L, (long)loaner.getAccount().getLoans().get(0));
    }
}
