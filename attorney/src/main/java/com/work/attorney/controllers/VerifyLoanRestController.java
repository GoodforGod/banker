package com.work.attorney.controllers;

import com.work.attorney.model.AttorneyResponse;
import com.work.attorney.model.LoanRequest;
import com.work.attorney.util.DigitUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.work.attorney.model.LoanStatus.APPROVED;
import static com.work.attorney.model.LoanStatus.REJECTED;

@RestController
public class VerifyLoanRestController {

    @PostMapping(value = "/verify")
    public AttorneyResponse verify(@RequestBody final LoanRequest request) {
        if (request == null || request.getBalance() == null || request.getAmount() == null)
            return new AttorneyResponse("Fraud detected.", REJECTED);

        if (request.getBalance() < 0)
            return new AttorneyResponse("Balance is negative.", REJECTED);

        if (DigitUtils.numberOfDigits(request.getBalance()) < 6)
            return new AttorneyResponse("Balance is insufficient for loan.", REJECTED);

        if (DigitUtils.numberOfDigits(request.getAmount()) > 4)
            return new AttorneyResponse("Loan is too big.", REJECTED);

        return new AttorneyResponse("Loan approved.", APPROVED);
    }
}
