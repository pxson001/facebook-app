package com.facebook.vault.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = BlacklistedSyncPathDeserializer.class)
/* compiled from: threads_temp */
public class BlacklistedSyncPath {
    @JsonProperty("path")
    public String path;
}
