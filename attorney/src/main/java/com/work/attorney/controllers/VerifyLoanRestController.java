package com.work.attorney.controllers;

import com.work.attorney.model.AttorneyResponse;
import com.work.attorney.model.LoanRequest;
import com.work.attorney.model.states.LoanVerdict;
import com.work.attorney.services.IAttorneyService;
import com.work.attorney.services.impl.AttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.work.attorney.model.AttorneyResponse.LoanStatus.APPROVED;
import static com.work.attorney.model.AttorneyResponse.LoanStatus.REJECTED;


@RestController
public class VerifyLoanRestController {

    private final IAttorneyService attorneyService;

    @Autowired
    public VerifyLoanRestController(final AttorneyService attorneyService) {
        this.attorneyService = attorneyService;
    }

    @GetMapping("/verify")
    public void verify() {

    }

    @PostMapping(value = "/verify")
    public AttorneyResponse verify(@RequestBody final LoanRequest request) {
        if (isRequestFraud(request))
            return new AttorneyResponse("Fraud detected.", REJECTED);

        final LoanVerdict verdict = attorneyService.verify(request.getBalance(), request.getAmount());

        switch (verdict) {
            case APPROVED:
                return new AttorneyResponse(verdict.getComment(), APPROVED, request.getAmount());

            default:
                return new AttorneyResponse(verdict.getComment(), REJECTED);
        }
    }

    private boolean isRequestFraud(final LoanRequest request) {
        return (request == null || request.getBalance() == null || request.getAmount() == null);
    }
}
