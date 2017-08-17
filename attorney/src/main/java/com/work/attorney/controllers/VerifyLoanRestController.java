package com.work.attorney.controllers;

import com.work.attorney.model.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyLoanRestController {

    @RequestMapping(value = "/verify")
    public RestResponse verify(@RequestParam("id") final Long clientId,
                               @RequestParam("amount") final Long loanAmount) {
        return (loanAmount != null && isLoanAmountAcceptable(loanAmount))
                ? new RestResponse("Loan granted.")
                : new RestResponse("Fraud detected.");
    }

    private boolean isLoanAmountAcceptable(final Long amount) {
        return (amount / 1000 <= 1);
    }
}
