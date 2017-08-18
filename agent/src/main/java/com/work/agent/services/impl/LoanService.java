package com.work.agent.services.impl;

import com.work.agent.model.Account;
import com.work.agent.model.AttorneyResponse;
import com.work.agent.model.Client;
import com.work.agent.model.LoanRequest;
import com.work.agent.services.IClientService;
import com.work.agent.services.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class LoanService implements ILoanService {

    private final RestTemplate restTemplate;
    private final IClientService clientService;

    @Autowired
    public LoanService(RestTemplate restTemplate, IClientService clientService) {
        this.restTemplate = restTemplate;
        this.clientService = clientService;
    }

    @Override
    public AttorneyResponse requestLoan(final Client client, final Long amount) {
        return this.restTemplate.exchange(
                RequestEntity.post(URI.create("http://localhost:" + 8888 + "/loan"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new LoanRequest(client.getAccount().getBalance(), amount)),
                AttorneyResponse.class)
                .getBody();
    }

    @Override
    public Account submitLoan(final Client client, final Long amount) {
        client.getAccount().addLoan(amount);
        clientService.update(client);
        return client.getAccount();
    }

    @Override
    public AttorneyResponse requestLoan(final Client client, final Integer amount) {
        return requestLoan(client, (long) amount);
    }

    @Override
    public Account submitLoan(final Client client, final Integer amount) {
        return submitLoan(client, (long) amount);
    }
}
