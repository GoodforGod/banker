package com.work.attorney.services.core;

import com.work.attorney.model.states.LoanVerdict;
import model.dto.loan.LoanRequest;

public interface IAttorneyService {

    /**
     * Returns verdict about clients loan request,
     * @see LoanVerdict
     *
     * @param request loan amount and balance to verify
     * @return loan verdict
     */
    LoanVerdict verify(final LoanRequest request);
}
