package com.work.agent.model;

public class AttorneyResponse {

    public enum LoanStatus {
        APPROVED,
        REJECTED
    }

    private String message;
    private LoanStatus status;

    public AttorneyResponse() { }

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
