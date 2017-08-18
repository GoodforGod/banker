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
        if (balance < 0)
            return BALANCE_NEGATIVE;

        if (DigitUtils.numberOfDigits(balance) < 6)
            return BALANCE_INSUFFICIENT;

        if (DigitUtils.numberOfDigits(amount) > 4)
            return HUGE_LOAN;

        return APPROVED;
    }

    @Override
    public LoanVerdict verify(final int balance, final int amount) {
        return verify((long)balance, (long)amount);
    }
}
