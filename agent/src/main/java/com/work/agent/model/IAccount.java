package com.work.agent.model;

import java.util.List;

public interface IAccount {
    Long replenish(final Long amount);
    Long replenish(final Integer amount);

    Long withdraw(final Long amount);
    Long withdraw(final Integer amount);

    Account addLoan(final Long amount);
    Account addLoan(final Integer amount);

    Long getBalance();

    List<Long> getLoans();
}
