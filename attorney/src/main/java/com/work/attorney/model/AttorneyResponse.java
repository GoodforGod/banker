package com.work.attorney.model;

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
