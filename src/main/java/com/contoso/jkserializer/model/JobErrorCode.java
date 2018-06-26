package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobErrorCode {
    SERVICE_ERROR("ServiceError"),

    SERVICE_TRANSIENT_ERROR("ServiceTransientError"),

    DOWNLOAD_NOT_ACCESSIBLE("DownloadNotAccessible"),

    DOWNLOAD_TRANSIENT_ERROR("DownloadTransientError"),

    UPLOAD_NOT_ACCESSIBLE("UploadNotAccessible"),

    UPLOAD_TRANSIENT_ERROR("UploadTransientError"),

    CONFIGURATION_UNSUPPORTED("ConfigurationUnsupported"),

    CONTENT_MALFORMED("ContentMalformed"),

    CONTENT_UNSUPPORTED("ContentUnsupported");

    private String value;

    JobErrorCode(String value) {
        this.value = value;
    }

    @JsonCreator
    public static JobErrorCode fromString(String value) {
        JobErrorCode[] items = JobErrorCode.values();
        for (JobErrorCode item : items) {
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