package com.facebook.vault.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VaultGetSyncedImageStatusDeserializer.class)
/* compiled from: thread_id IN (SELECT thread_id FROM #thread_fbid) AND timestamp >= %1$d */
public class VaultGetSyncedImageStatus {
    @JsonProperty("deleted")
    public final boolean mDeleted = false;
    @JsonProperty("id")
    public final long mFbid = 0;
    @JsonProperty("height")
    public final int mHeight = 0;
    @JsonProperty("width")
    public final int mWidth = 0;

    public boolean equals(Object obj) {
        VaultGetSyncedImageStatus vaultGetSyncedImageStatus = (VaultGetSyncedImageStatus) obj;
        return vaultGetSyncedImageStatus.mFbid == this.mFbid && vaultGetSyncedImageStatus.mDeleted == this.mDeleted && vaultGetSyncedImageStatus.mWidth == this.mWidth && vaultGetSyncedImageStatus.mHeight == this.mHeight;
    }
}
