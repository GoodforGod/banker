package com.work.agent.services;

import com.work.agent.model.Client;
import com.work.agent.model.LoanStatus;

public interface ILoanService {
    LoanStatus requestLoan(final Client client, final Long amount);
}
