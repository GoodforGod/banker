package com.work.agent.model;

import java.util.List;

public interface IAccount {
    Long replenish(final Long amount);
    Long replenish(final Integer amount);

    Long withdraw(final Long amount);
    Long withdraw(final Integer amount);

    Long addLoan(final Long amount);
    Long addLoan(final Integer amount);

    Long getBalance();

    List<Long> getLoans();
}
