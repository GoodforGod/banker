package com.work.attorney.services.core;

import com.work.attorney.model.states.LoanVerdict;

public interface IAttorneyService {

    /**
     * Returns verdict about clients loan request,
     * @see LoanVerdict
     *
     * @param balance loan balance to verify
     * @param amount loan amount of loan to request
     * @return loan verdict
     */
    LoanVerdict verify(final Long balance, final Long amount);

    /**
     *
     * @param balance loan balance to verify
     * @param amount loan amount of loan to request
     * @return loan verdict
     */
    LoanVerdict verify(final Integer balance, final Integer amount);
}
