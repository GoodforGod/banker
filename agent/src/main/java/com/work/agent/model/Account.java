package com.work.agent.model;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {

    private Long balance = 0L;
    private List<Long> loans = new ArrayList<>();

    @Override
    public Long replenish(final Long amount) {
        return balance += amount;
    }

    @Override
    public Long withdraw(final Long amount) {
        return (balance > amount)
                ? balance -= amount
                : null;
    }

    @Override
    public Account addLoan(final Long amount) {
        loans.add(amount);
        return this;
    }

    //<editor-fold desc="For Integers">

    @Override
    public Long withdraw(Integer amount) {
        return withdraw((long) amount);
    }


    @Override
    public Long replenish(Integer amount) {
        return replenish((long) amount);
    }


    @Override
    public Account addLoan(Integer amount) {
        return addLoan((long) amount);
    }
    //</editor-fold>

    @Override
    public Long getBalance() {
        return balance;
    }

    @Override
    public List<Long> getLoans() {
        return loans;
    }
}
