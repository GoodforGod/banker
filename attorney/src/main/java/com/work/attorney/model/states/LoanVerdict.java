package com.work.attorney.model.states;

public enum LoanVerdict {
    /**
     *  If all check were passed
     */
    APPROVED("Loan approved."),

    /**
     * If loan is more than 5 digits
     */
    HUGE_LOAN("Loan is too big."),

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
