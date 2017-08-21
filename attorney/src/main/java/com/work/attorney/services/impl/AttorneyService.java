package com.work.attorney.services.impl;

import com.work.attorney.model.states.LoanVerdict;
import com.work.attorney.services.IAttorneyService;
import com.work.attorney.util.DigitUtils;
import org.springframework.stereotype.Service;

import static com.work.attorney.model.states.LoanVerdict.*;

@Service
public class AttorneyService implements IAttorneyService {

    @Override
    public LoanVerdict verify(final long balance, final long amount) {
        if (balance <= 0)
            return BALANCE_NEGATIVE;

        if(amount <= 0)
            return LOAN_NEGATIVE;

        int SUFFICIENT_BALANCE_NUMBER_OF_DIGITS = 5;
        if (DigitUtils.numberOfDigits(balance) <= SUFFICIENT_BALANCE_NUMBER_OF_DIGITS)
            return BALANCE_INSUFFICIENT;

        int MAX_LOAN_NUMBER_OF_DIGITS = 4;
        if (DigitUtils.numberOfDigits(amount) > MAX_LOAN_NUMBER_OF_DIGITS)
            return LOAN_HUGE;

        return LOAN_APPROVED;
    }

    @Override
    public LoanVerdict verify(final int balance, final int amount) {
        return verify((long)balance, (long)amount);
    }
}
