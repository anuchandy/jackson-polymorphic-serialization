package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for JobErrorCategory.
 */
public enum JobErrorCategory {
    SERVICE("Service"),

    DOWNLOAD("Download"),

    UPLOAD("Upload"),

    CONFIGURATION("Configuration"),

    CONTENT("Content");

    private String value;

    JobErrorCategory(String value) {
        this.value = value;
    }

    @JsonCreator
    public static JobErrorCategory fromString(String value) {
        JobErrorCategory[] items = JobErrorCategory.values();
        for (JobErrorCategory item : items) {
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
