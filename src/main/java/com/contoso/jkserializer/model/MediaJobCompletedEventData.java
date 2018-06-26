package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MediaJobCompletedEventData {
    @JsonProperty(value = "stautoate")
    private String state;

    @JsonProperty(value = "dataVersion")
    private String dataVersion;

    @JsonProperty(value = "outputs")
    private List<JobOutput> outputs;

    public String state() {
        return this.state;
    }

    public MediaJobCompletedEventData withState(String state) {
        this.state = state;
        return this;
    }

    public String dataVersion() {
        return this.dataVersion;
    }

    public MediaJobCompletedEventData withDataVersion(String dataVersion) {
        this.state = dataVersion;
        return this;
    }

    public List<JobOutput> outputs() {
        return this.outputs;
    }

    public MediaJobCompletedEventData withOutputs(List<JobOutput> outputs) {
        this.outputs = outputs;
        return this;
    }
}
