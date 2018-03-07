package com.facebook.video.videostreaming.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = VideoBroadcastAudioStreamingConfigDeserializer.class)
@JsonSerialize(using = VideoBroadcastAudioStreamingConfigSerializer.class)
/* compiled from: rotation_degree */
public class VideoBroadcastAudioStreamingConfig implements Parcelable {
    public static final Creator<VideoBroadcastAudioStreamingConfig> CREATOR = new C03311();
    @JsonProperty("bit_rate")
    public final int bitRate;
    @JsonProperty("channels")
    public final int channels;
    @JsonProperty("sample_rate")
    public final int sampleRate;

    /* compiled from: rotation_degree */
    final class C03311 implements Creator<VideoBroadcastAudioStreamingConfig> {
        C03311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoBroadcastAudioStreamingConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoBroadcastAudioStreamingConfig[i];
        }
    }

    /* compiled from: rotation_degree */
    public class Builder {
        public int f5446a = 0;
        public int f5447b = 0;
        public int f5448c = 0;

        public final Builder m8125a(int i) {
            this.f5446a = i;
            return this;
        }

        public final Builder m8127b(int i) {
            this.f5447b = i;
            return this;
        }

        public final Builder m8128c(int i) {
            this.f5448c = i;
            return this;
        }

        public final VideoBroadcastAudioStreamingConfig m8126a() {
            return new VideoBroadcastAudioStreamingConfig(this);
        }
    }

    @JsonIgnore
    private VideoBroadcastAudioStreamingConfig() {
        this(new Builder());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.bitRate);
        parcel.writeInt(this.channels);
    }

    public VideoBroadcastAudioStreamingConfig(Parcel parcel) {
        this.sampleRate = parcel.readInt();
        this.bitRate = parcel.readInt();
        this.channels = parcel.readInt();
    }

    public VideoBroadcastAudioStreamingConfig(Builder builder) {
        this.sampleRate = builder.f5446a;
        this.bitRate = builder.f5447b;
        this.channels = builder.f5448c;
    }
}
