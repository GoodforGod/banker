package com.work.attorney.model;

public class LoanRequest {

    private Long balance;
    private Long amount;

    public LoanRequest(Long balance, Long amount) {
        this.balance = balance;
        this.amount = amount;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getAmount() {
        return amount;
    }
}
