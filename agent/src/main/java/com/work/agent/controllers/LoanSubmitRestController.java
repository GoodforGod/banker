package com.work.agent.controllers;

import com.work.agent.services.ILoanService;
import com.work.agent.services.impl.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanSubmitRestController {

    private final ILoanService loanService;

    @Autowired
    public LoanSubmitRestController(final LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loan")
    public String getLoan(@RequestParam("name") String name,
                          @RequestParam("amount") Long amount) {
        return null;
    }
}
