package com.facebook.vault.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VaultPagingObjectDeserializer.class)
/* compiled from: threadName */
public class VaultPagingObject {
    @JsonProperty("cursors")
    public Map<String, String> cursors;
    @JsonProperty("next")
    public String next;
}
