package com.work.attorney.controllers;

import com.work.attorney.model.AttorneyResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.work.attorney.model.LoanStatus.APPROVED;
import static com.work.attorney.model.LoanStatus.REJECTED;

@RestController
public class VerifyLoanRestController {

    @PostMapping(value = "/verify")
    public AttorneyResponse verify(@RequestParam("amount") final Long loanAmount,
                                   @RequestParam("balance") final Long clientBalance) {
        return (loanAmount != null && isLoanAmountAcceptable(loanAmount, clientBalance))
                ? new AttorneyResponse("Loan granted.", APPROVED)
                : new AttorneyResponse("Fraud detected.", REJECTED);
    }

    private boolean isLoanAmountAcceptable(final Long amount, final Long balance) {
        return (balance != null && balance > 0) && (amount / balance <= 2);
    }
}
