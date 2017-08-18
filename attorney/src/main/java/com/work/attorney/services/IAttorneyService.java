package com.work.attorney.services;

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
    LoanVerdict verify(final long balance, final long amount);

    /**
     *
     * @param balance loan balance to verify
     * @param amount loan amount of loan to request
     * @return loan verdict
     */
    LoanVerdict verify(final int balance, final int amount);
}
