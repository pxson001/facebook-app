package com.facebook.vault.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Maps;
import java.util.Map;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VaultGetSyncedImageStatusResultDeserializer.class)
/* compiled from: thread_id IN (SELECT thread_id FROM #canonical_thread_id) AND timestamp >= %1$d */
public class VaultGetSyncedImageStatusResult {
    @JsonProperty("data")
    public Map<String, VaultGetSyncedImageStatus> mResult = Maps.c();

    VaultGetSyncedImageStatusResult() {
    }

    public final Map<String, VaultGetSyncedImageStatus> m1941a() {
        return this.mResult;
    }
}
