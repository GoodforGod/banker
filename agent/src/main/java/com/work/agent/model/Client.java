package com.work.agent.model;

import java.util.UUID;

public class Client {

    private Long id = UUID.randomUUID().getMostSignificantBits();
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
