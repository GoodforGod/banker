package com.work.agent.model;

public class Account {

    private Long balance = 0L;
    private Long loans = 0L;

    public Long addBalance(final Long amount) {
        return balance += amount;
    }

    public Long addLoans(final Long amount) {
        return loans += amount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(final Long balance) {
        this.balance = balance;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }
}
