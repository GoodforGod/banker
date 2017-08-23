package com.work.attorney.services.core.impl;

import com.work.attorney.model.states.LoanVerdict;
import com.work.attorney.services.core.IAttorneyService;
import com.work.attorney.util.DigitUtils;
import model.dto.loan.LoanRequest;
import org.springframework.stereotype.Service;

import static com.work.attorney.model.states.LoanVerdict.*;

@Service
public class AttorneyService implements IAttorneyService {

    @Override
    public LoanVerdict verify(final LoanRequest request) {
        final Long balance = request.getBalance();
        final Long loanAmount = request.getAmount();

        if(balance == null || balance == 0)
            return FRAUD;

        if (balance < 0)
            return BALANCE_NEGATIVE;

        if(loanAmount == null || loanAmount <= 0)
            return LOAN_NEGATIVE;

        final int SUFFICIENT_BALANCE_NUMBER_OF_DIGITS = 5;
        if (DigitUtils.numberOfDigits(balance) < SUFFICIENT_BALANCE_NUMBER_OF_DIGITS)
            return BALANCE_INSUFFICIENT;

        final int MAX_LOAN_NUMBER_OF_DIGITS = 5;
        if (DigitUtils.numberOfDigits(loanAmount) > MAX_LOAN_NUMBER_OF_DIGITS)
            return LOAN_HUGE;

        return LOAN_APPROVED;
    }
}
