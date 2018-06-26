package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for JobRetry.
 */
public enum JobRetry {
    DO_NOT_RETRY("DoNotRetry"),

    MAY_RETRY("MayRetry");

    private String value;

    JobRetry(String value) {
        this.value = value;
    }

    @JsonCreator
    public static JobRetry fromString(String value) {
        JobRetry[] items = JobRetry.values();
        for (JobRetry item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}