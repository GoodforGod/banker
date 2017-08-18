package com.work.agent.services;

import com.work.agent.model.Client;
import com.work.agent.services.impl.ClientService;
import com.work.agent.services.impl.LoanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceTest {

    @Autowired
    private LoanService loanService;

    @Autowired
    private ClientService clientService;

    public void loanRequestSuccess() {

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
