package com.work.attorney.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LoanAttachment {

    @Id
    @GeneratedValue
    private Long id;

    private Long amount;

    public LoanAttachment(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }
}
