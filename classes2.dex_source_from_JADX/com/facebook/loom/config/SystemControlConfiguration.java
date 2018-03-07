package com.facebook.loom.config;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.concurrent.TimeUnit;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SystemControlConfigurationDeserializer.class)
/* compiled from: zero_rating2/clearable/default_optin/image_url_key */
public class SystemControlConfiguration {
    @JsonProperty("upload_bytes_per_update")
    private final long mUploadBytesPerUpdate = 416;
    @JsonProperty("upload_max_bytes")
    private final long mUploadMaxBytes = 10000;
    @JsonProperty("upload_time_period_sec")
    private final long mUploadTimePeriodSec = TimeUnit.HOURS.toSeconds(1);

    public long m938a() {
        return this.mUploadMaxBytes;
    }

    public long m939b() {
        return this.mUploadBytesPerUpdate;
    }

    public long m940c() {
        return this.mUploadTimePeriodSec;
    }
}
