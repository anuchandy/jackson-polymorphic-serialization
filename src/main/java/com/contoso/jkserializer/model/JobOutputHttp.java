package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Media.JobOutputHttp")
public class JobOutputHttp extends JobOutput {
    @JsonProperty(value = "url", required = true)
    private String url;

    public String url() {
        return this.url;
    }

    public JobOutputHttp withUrl(String url) {
        this.url = url;
        return this;
    }
}
