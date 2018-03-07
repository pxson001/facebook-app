package com.facebook.vault.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = BlacklistedSyncPathsGroupDeserializer.class)
/* compiled from: threads_fetch_no_folder */
public class BlacklistedSyncPathsGroup {
    @JsonProperty("data")
    public List<BlacklistedSyncPath> paths;
}
