package com.facebook.vault.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VaultAllImagesGetResultDeserializer.class)
/* compiled from: thread_id IN (SELECT thread_id FROM #threads) */
public class VaultAllImagesGetResult {
    @JsonProperty("data")
    public List<VaultImageResultObject> data = null;
    @JsonProperty("paging")
    public VaultPagingObject paging = null;
}
