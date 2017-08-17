package com.work.agent.model;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Client {

    private Long id = current().nextLong();
    private String name;
    private Account account = new Account();

    public Client(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}
