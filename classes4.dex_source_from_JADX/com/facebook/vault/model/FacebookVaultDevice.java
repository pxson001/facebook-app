package com.facebook.vault.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FacebookVaultDeviceDeserializer.class)
/* compiled from: fetchFollowUpFeedUnitParamsKey */
public class FacebookVaultDevice {
    @JsonProperty("enabled")
    public final boolean mEnabled = false;
    @JsonProperty("id")
    public final long mFbid = 0;
    @JsonProperty("identifier_value")
    public final String mIdentifier = "";
    @JsonProperty("last_sync_time")
    public final long mLastSyncTime = 0;
    @JsonProperty("owner_id")
    public final long mOwnerId = 0;
    @JsonProperty("sync_mode")
    public final String mSyncMode = "WIFI_ONLY";
    @JsonProperty("sync_older_photos")
    public final boolean mSyncOlderPhotos = false;
    @JsonProperty("date_created")
    public final long mTimeCreated = 0;

    private FacebookVaultDevice() {
    }

    public static boolean m12371a(String str) {
        return str.equals("MOBILE_RADIO") || str.equals("WIFI_ONLY");
    }
}
