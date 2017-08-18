package com.work.agent.controllers;

import com.work.agent.model.AttorneyResponse;
import com.work.agent.model.Client;
import com.work.agent.services.IClientService;
import com.work.agent.services.ILoanService;
import com.work.agent.services.impl.ClientService;
import com.work.agent.services.impl.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanSubmitRestController {

    private final ILoanService loanService;
    private final IClientService clientService;

    @Autowired
    public LoanSubmitRestController(final LoanService loanService,
                                    final ClientService clientService) {
        this.loanService = loanService;
        this.clientService = clientService;
    }

    @PostMapping("/loan")
    public String requestLoan(@RequestParam("id") final Long id,
                              @RequestParam("amount") final Long loanAmount) {
        final Client client = clientService.find(id);

        if(client == null)
            return "CLIENT DOES NOT EXIST.";

        if(loanAmount == null || loanAmount < 0)
            return "INVALID LOAN AMOUNT.";

        final AttorneyResponse.LoanStatus status = loanService.requestLoan(client, loanAmount);

        switch (status) {
            case APPROVED:
                loanService.submitLoan(client, loanAmount);
                return "LOAN APPROVED!";

            default:
                return "LOAN WAS REJECTED.";
        }
    }
}
