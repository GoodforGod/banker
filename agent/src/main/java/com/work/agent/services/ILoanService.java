package com.work.agent.services;

import com.work.agent.model.AttorneyResponse;
import com.work.agent.model.Client;

public interface ILoanService {
    AttorneyResponse.LoanStatus requestLoan(final Client client, final Long amount);
}
