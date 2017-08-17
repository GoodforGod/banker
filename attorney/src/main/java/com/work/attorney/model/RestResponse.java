package com.work.attorney.model;

public class RestResponse {

    private String message;

    public RestResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
