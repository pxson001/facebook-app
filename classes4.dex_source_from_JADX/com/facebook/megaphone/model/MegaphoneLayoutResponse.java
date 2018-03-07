package com.facebook.megaphone.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = MegaphoneLayoutResponseDeserializer.class)
/* compiled from: fbns/ */
public class MegaphoneLayoutResponse {
    @JsonProperty("cache_id")
    public final String cacheId = null;
    @JsonProperty("data")
    public final String layout = null;
}
