package com.work.agent.services;

import com.work.agent.model.Account;
import com.work.agent.model.Client;
import model.dto.loan.AttorneyResponse;

public interface ILoanService {

    AttorneyResponse requestLoan(final Client client, final Long amount);
    AttorneyResponse requestLoan(final Client client, final Integer amount);

    Account submitLoan(final Client client, final AttorneyResponse response);
}
