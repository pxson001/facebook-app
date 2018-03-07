package com.facebook.video.videostreaming.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = VideoBroadcastVideoStreamingConfigDeserializer.class)
@JsonSerialize(using = VideoBroadcastVideoStreamingConfigSerializer.class)
/* compiled from: reviews_post_review_success */
public class VideoBroadcastVideoStreamingConfig implements Parcelable {
    public static final Creator<VideoBroadcastVideoStreamingConfig> CREATOR = new C03331();
    @JsonProperty("allow_b_frames")
    public final boolean allowBFrames;
    @JsonProperty("bit_rate")
    public final int bitRate;
    @JsonProperty("frame_rate")
    public final int frameRate;
    @JsonProperty("height")
    public final int height;
    @JsonProperty("video_profile")
    public final String videoProfile;
    @JsonProperty("width")
    public final int width;

    /* compiled from: reviews_post_review_success */
    final class C03331 implements Creator<VideoBroadcastVideoStreamingConfig> {
        C03331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoBroadcastVideoStreamingConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoBroadcastVideoStreamingConfig[i];
        }
    }

    /* compiled from: reviews_post_review_success */
    public class Builder {
        public int f5470a = 0;
        public int f5471b = 0;
        public int f5472c = 0;
        public int f5473d = 0;
        public boolean f5474e = false;
        public String f5475f = null;

        public Builder(VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig) {
            this.f5470a = videoBroadcastVideoStreamingConfig.width;
            this.f5471b = videoBroadcastVideoStreamingConfig.height;
            this.f5472c = videoBroadcastVideoStreamingConfig.bitRate;
            this.f5473d = videoBroadcastVideoStreamingConfig.frameRate;
            this.f5474e = videoBroadcastVideoStreamingConfig.allowBFrames;
            this.f5475f = videoBroadcastVideoStreamingConfig.videoProfile;
        }

        public final Builder m8146a(int i) {
            this.f5470a = i;
            return this;
        }

        public final Builder m8150b(int i) {
            this.f5471b = i;
            return this;
        }

        public final Builder m8151c(int i) {
            this.f5472c = i;
            return this;
        }

        public final Builder m8152d(int i) {
            this.f5473d = i;
            return this;
        }

        public final Builder m8148a(boolean z) {
            this.f5474e = z;
            return this;
        }

        public final Builder m8147a(String str) {
            this.f5475f = str;
            return this;
        }

        public final VideoBroadcastVideoStreamingConfig m8149a() {
            return new VideoBroadcastVideoStreamingConfig(this);
        }
    }

    @JsonIgnore
    private VideoBroadcastVideoStreamingConfig() {
        this(new Builder());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.bitRate);
        parcel.writeInt(this.frameRate);
        ParcelUtil.a(parcel, this.allowBFrames);
        parcel.writeString(this.videoProfile);
    }

    public VideoBroadcastVideoStreamingConfig(Builder builder) {
        this.width = builder.f5470a;
        this.height = builder.f5471b;
        this.bitRate = builder.f5472c;
        this.frameRate = builder.f5473d;
        this.allowBFrames = builder.f5474e;
        this.videoProfile = builder.f5475f;
    }

    public VideoBroadcastVideoStreamingConfig(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bitRate = parcel.readInt();
        this.frameRate = parcel.readInt();
        this.allowBFrames = ParcelUtil.a(parcel);
        this.videoProfile = parcel.readString();
    }
}
