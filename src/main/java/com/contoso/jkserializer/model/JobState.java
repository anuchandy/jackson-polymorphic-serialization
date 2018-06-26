package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobState {
    CANCELED("Canceled"),

    CANCELING("Canceling"),

    ERROR("Error"),

    FINISHED("Finished"),

    PROCESSING("Processing"),

    QUEUED("Queued"),

    SCHEDULED("Scheduled");

    private String value;

    JobState(String value) {
        this.value = value;
    }

    @JsonCreator
    public static JobState fromString(String value) {
        JobState[] items = JobState.values();
        for (JobState item : items) {
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