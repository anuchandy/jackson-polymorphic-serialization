package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobErrorDetail {
    @JsonProperty(value = "code", access = JsonProperty.Access.WRITE_ONLY)
    private String code;

    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
