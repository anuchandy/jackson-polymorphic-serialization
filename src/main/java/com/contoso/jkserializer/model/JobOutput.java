package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("JobOutput")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "#Microsoft.Media.JobOutputAsset", value = JobOutputAsset.class),
        @JsonSubTypes.Type(name = "#Microsoft.Media.JobOutputHttp", value = JobOutputHttp.class)
})
public class JobOutput {
    @JsonProperty(value = "error", access = JsonProperty.Access.WRITE_ONLY)
    private JobError error;

    @JsonProperty(value = "state", access = JsonProperty.Access.WRITE_ONLY)
    private JobState state;

    @JsonProperty(value = "progress", access = JsonProperty.Access.WRITE_ONLY)
    private int progress;

    public JobError error() {
        return this.error;
    }

    public JobState state() {
        return this.state;
    }

    public int progress() {
        return this.progress;
    }

}
