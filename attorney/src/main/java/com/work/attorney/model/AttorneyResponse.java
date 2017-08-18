package com.work.attorney.model;

import com.work.attorney.model.states.LoanStatus;

public class AttorneyResponse {

    private String message;
    private LoanStatus status;

    public AttorneyResponse(final String message,
                            final LoanStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public LoanStatus getStatus() {
        return status;
    }
}
