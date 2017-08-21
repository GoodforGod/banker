package com.work.agent.model;

public class AttorneyResponse {

    public enum LoanStatus {
        APPROVED,
        REJECTED
    }

    private String message;
    private LoanStatus status;
    private Long approvedLoan;

    public AttorneyResponse() { }

    public AttorneyResponse(final String message,
                            final LoanStatus status,
                            final Long approvedLoan) {
        this.message = message;
        this.status = status;
        this.approvedLoan = approvedLoan;
    }

    public String getMessage() {
        return message;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public Long getApprovedLoan() {
        return approvedLoan;
    }
}
