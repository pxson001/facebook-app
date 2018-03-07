package com.facebook.vault.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VaultImageResultObjectDeserializer.class)
/* compiled from: thread_count */
public class VaultImageResultObject {
    @JsonProperty("date_taken")
    public String dateTaken;
    @JsonProperty("id")
    public long fbid;
    @JsonProperty("height")
    public int height;
    @JsonProperty("source")
    public String uri;
    @JsonProperty("width")
    public int width;
}
