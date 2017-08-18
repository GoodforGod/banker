package com.work.agent.services.impl;

import com.work.agent.model.AttorneyResponse;
import com.work.agent.model.Client;
import com.work.agent.model.LoanRequest;
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

    @Autowired
    public LoanService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AttorneyResponse.LoanStatus requestLoan(final Client client, final Long amount) {
        return this.restTemplate.exchange(
                RequestEntity.post(URI.create("http://localhost:" + 8888 + "/loan"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new LoanRequest(client.getAccount().getBalance(), amount)),
                AttorneyResponse.class)
                .getBody().getStatus();
    }
}
