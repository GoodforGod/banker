package com.work.attorney.controllers;

import com.work.attorney.model.states.LoanVerdict;
import com.work.attorney.services.core.IAttorneyService;
import com.work.attorney.services.core.impl.AttorneyService;
import model.dto.loan.AttorneyResponse;
import model.dto.loan.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static model.dto.loan.AttorneyResponse.LoanStatus.APPROVED;
import static model.dto.loan.AttorneyResponse.LoanStatus.REJECTED;


@RestController
public class VerifyLoanRestController {

    private final IAttorneyService attorneyService;

    @Autowired
    public VerifyLoanRestController(final AttorneyService attorneyService) {
        this.attorneyService = attorneyService;
    }

    @PostMapping(value = "/verify")
    public AttorneyResponse verify(@RequestBody final LoanRequest request) {
        final LoanVerdict verdict = attorneyService.verify(request);

        switch (verdict) {
            case LOAN_APPROVED:
                return new AttorneyResponse(verdict.getComment(), APPROVED, request.getAmount());

            default:
                return new AttorneyResponse(verdict.getComment(), REJECTED);
        }
    }
}
