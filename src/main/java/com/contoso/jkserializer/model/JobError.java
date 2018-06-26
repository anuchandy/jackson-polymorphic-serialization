package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JobError {

    @JsonProperty(value = "code", access = JsonProperty.Access.WRITE_ONLY)
    private JobErrorCode code;

    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    @JsonProperty(value = "category", access = JsonProperty.Access.WRITE_ONLY)
    private JobErrorCategory category;

    @JsonProperty(value = "retry", access = JsonProperty.Access.WRITE_ONLY)
    private JobRetry retry;

    @JsonProperty(value = "details", access = JsonProperty.Access.WRITE_ONLY)
    private List<JobErrorDetail> details;

    public JobErrorCode code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public JobErrorCategory category() {
        return this.category;
    }

    public JobRetry retry() {
        return this.retry;
    }

    public List<JobErrorDetail> details() {
        return this.details;
    }

}