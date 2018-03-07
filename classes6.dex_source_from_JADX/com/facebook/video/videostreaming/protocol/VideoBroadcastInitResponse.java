package com.facebook.video.videostreaming.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = VideoBroadcastInitResponseDeserializer.class)
@JsonSerialize(using = VideoBroadcastInitResponseSerializer.class)
/* compiled from: robotext_tags */
public class VideoBroadcastInitResponse implements Parcelable {
    public static final Creator<VideoBroadcastInitResponse> CREATOR = new C03321();
    private static final String f5468a = VideoBroadcastInitResponse.class.getSimpleName();
    @JsonProperty("audio_streaming_config")
    @Nullable
    public final VideoBroadcastAudioStreamingConfig audioStreamingConfig;
    @JsonProperty("broadcast_id")
    public final String broadcastId;
    @JsonProperty("client_rendering_duration_ms")
    public final long clientRenderingDurationMs;
    @JsonProperty("is_disk_recording_enabled")
    public final boolean mIsDiskRecordingEnabled;
    @JsonProperty("raw_json_config")
    @Nullable
    public final String mRawJsonConfig;
    @JsonProperty("max_broadcast_duration")
    public final long maxBroadcastDurationSeconds;
    @JsonProperty("min_broadacst_duration")
    public final long minBroadcastDurationSeconds;
    @JsonProperty("rtmp_publish_url")
    public final String rtmpPublishUrl;
    @JsonProperty("send_stream_interrupted_interval")
    public final long sendStreamInterruptedIntervalInSeconds;
    @JsonProperty("speed_test_timeout_seconds")
    public final long speedTestTimeoutSeconds;
    @JsonProperty("video_id")
    public final String videoId;
    @JsonProperty("video_streaming_config")
    @Nullable
    public final VideoBroadcastVideoStreamingConfig videoStreamingConfig;

    /* compiled from: robotext_tags */
    final class C03321 implements Creator<VideoBroadcastInitResponse> {
        C03321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoBroadcastInitResponse(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoBroadcastInitResponse[i];
        }
    }

    /* compiled from: robotext_tags */
    public class Builder {
        public String f5456a = "";
        public String f5457b = "";
        public String f5458c = "";
        public long f5459d = 0;
        public long f5460e = 0;
        public long f5461f = 0;
        public long f5462g = 0;
        @Nullable
        public VideoBroadcastVideoStreamingConfig f5463h;
        @Nullable
        public VideoBroadcastAudioStreamingConfig f5464i;
        @Nullable
        public String f5465j;
        public boolean f5466k;
        public long f5467l = 0;

        public final VideoBroadcastInitResponse m8140a() {
            return new VideoBroadcastInitResponse(this);
        }
    }

    @JsonIgnore
    private VideoBroadcastInitResponse() {
        this(new Builder());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.rtmpPublishUrl);
        parcel.writeString(this.videoId);
        parcel.writeString(this.broadcastId);
        parcel.writeLong(this.minBroadcastDurationSeconds);
        parcel.writeLong(this.maxBroadcastDurationSeconds);
        parcel.writeLong(this.speedTestTimeoutSeconds);
        parcel.writeLong(this.sendStreamInterruptedIntervalInSeconds);
        parcel.writeParcelable(this.videoStreamingConfig, i);
        parcel.writeParcelable(this.audioStreamingConfig, i);
        parcel.writeString(this.mRawJsonConfig);
        parcel.writeByte((byte) (this.mIsDiskRecordingEnabled ? 1 : 0));
        parcel.writeLong(this.clientRenderingDurationMs);
    }

    public VideoBroadcastInitResponse(Parcel parcel) {
        this.rtmpPublishUrl = parcel.readString();
        this.videoId = parcel.readString();
        this.broadcastId = parcel.readString();
        this.minBroadcastDurationSeconds = parcel.readLong();
        this.maxBroadcastDurationSeconds = parcel.readLong();
        this.speedTestTimeoutSeconds = parcel.readLong();
        this.sendStreamInterruptedIntervalInSeconds = parcel.readLong();
        this.videoStreamingConfig = (VideoBroadcastVideoStreamingConfig) parcel.readParcelable(VideoBroadcastVideoStreamingConfig.class.getClassLoader());
        this.audioStreamingConfig = (VideoBroadcastAudioStreamingConfig) parcel.readParcelable(VideoBroadcastAudioStreamingConfig.class.getClassLoader());
        this.mRawJsonConfig = parcel.readString();
        this.mIsDiskRecordingEnabled = parcel.readByte() != (byte) 0;
        this.clientRenderingDurationMs = parcel.readLong();
    }

    public VideoBroadcastInitResponse(Builder builder) {
        this.rtmpPublishUrl = builder.f5456a;
        this.videoId = builder.f5457b;
        this.broadcastId = builder.f5458c;
        this.minBroadcastDurationSeconds = builder.f5459d;
        this.maxBroadcastDurationSeconds = builder.f5460e;
        this.speedTestTimeoutSeconds = builder.f5461f;
        this.sendStreamInterruptedIntervalInSeconds = builder.f5462g;
        this.videoStreamingConfig = builder.f5463h;
        this.audioStreamingConfig = builder.f5464i;
        this.mRawJsonConfig = builder.f5465j;
        this.mIsDiskRecordingEnabled = builder.f5466k;
        this.clientRenderingDurationMs = builder.f5467l;
    }

    public final JsonNode m8141a() {
        JsonNode jsonNode = null;
        try {
            if (this.mRawJsonConfig != null) {
                jsonNode = FbObjectMapper.i().a(this.mRawJsonConfig);
            }
        } catch (Throwable e) {
            BLog.b(f5468a, "Failed to read the broadcast configuration", e);
        }
        return jsonNode;
    }
}
