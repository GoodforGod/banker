package com.work.attorney.model.states;

public enum LoanVerdict {
    /**
     *  If all check were passed
     */
    LOAN_APPROVED("Loan approved."),

    /**
     * If loan is more than 5 digits
     */
    LOAN_HUGE("Loan is too big."),

    /**
     * If loan is negative value
     */
    LOAN_NEGATIVE("Loan is negative value."),

    /**
     * If balance is less than 6 digits
     */
    BALANCE_INSUFFICIENT("Balance is insufficient for loan."),

    /**
     * If balance is negative
     */
    BALANCE_NEGATIVE("Balance is negative."),

    /**
     * Reserved
     */
    FRAUD("Fraud detected.");

    private String comment;

    LoanVerdict(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
