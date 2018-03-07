package com.facebook.photos.upload.operation;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = TranscodeInfoDeserializer.class)
@JsonSerialize(using = TranscodeInfoSerializer.class)
/* compiled from: gms_upsell_result */
public class TranscodeInfo {
    public static int f13689a = -1;
    @JsonProperty("flowStartCount")
    public long flowStartCount;
    @JsonProperty("isRequestedServerSettings")
    public boolean isRequestedServerSettings;
    @JsonProperty("isSegmentedTranscode")
    public boolean isSegmentedTranscode;
    @JsonProperty("isServerSettingsAvailable")
    public boolean isServerSettingsAvailable;
    @JsonProperty("serverSpecifiedTranscodeBitrate")
    public long serverSpecifiedTranscodeBitrate;
    @JsonProperty("serverSpecifiedTranscodeDimension")
    public long serverSpecifiedTranscodeDimension;
    @JsonProperty("transcodeFailCount")
    public long transcodeFailCount;
    @JsonProperty("transcodeStartCount")
    public long transcodeStartCount;
    @JsonProperty("transcodeSuccessCount")
    public long transcodeSuccessCount;

    private TranscodeInfo() {
    }

    public TranscodeInfo(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, long j5, long j6) {
        this.flowStartCount = j;
        this.transcodeStartCount = j2;
        this.transcodeSuccessCount = j3;
        this.transcodeFailCount = j4;
        this.isSegmentedTranscode = z;
        this.isRequestedServerSettings = z2;
        this.isServerSettingsAvailable = z3;
        this.serverSpecifiedTranscodeBitrate = j5;
        this.serverSpecifiedTranscodeDimension = j6;
    }
}
