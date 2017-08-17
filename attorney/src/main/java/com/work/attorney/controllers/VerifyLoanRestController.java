package com.work.attorney.controllers;

import com.work.attorney.model.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyLoanRestController {

    @RequestMapping(value = "/verify")
    public ResponseEntity<RestResponse> verify(@RequestParam("id") final Long clientId,
                                               @RequestParam("amount") final Long loanAmount) {
        return (loanAmount != null && isLoanAmountAcceptable(loanAmount))
                ? new ResponseEntity<RestResponse>(new RestResponse("Loan granted."), HttpStatus.OK)
                : new ResponseEntity<RestResponse>(new RestResponse("Fraud detected."), HttpStatus.BAD_REQUEST);
    }

    private boolean isLoanAmountAcceptable(final Long amount) {
        return (amount / 1000 <= 1);
    }
}
