package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Media.JobOutputAsset")
public class JobOutputAsset extends JobOutput {
    @JsonProperty(value = "assetName", required = true)
    private String assetName;

    public String assetName() {
        return this.assetName;
    }

    public JobOutputAsset withAssetName(String assetName) {
        this.assetName = assetName;
        return this;
    }
}
