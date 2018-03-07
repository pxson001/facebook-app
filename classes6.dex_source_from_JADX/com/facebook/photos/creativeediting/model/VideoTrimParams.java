package com.facebook.photos.creativeediting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = VideoTrimParamsDeserializer.class)
@JsonSerialize(using = VideoTrimParamsSerializer.class)
/* compiled from: suggestions is null at index  */
public class VideoTrimParams implements Parcelable {
    public static final Creator<VideoTrimParams> CREATOR = new C02181();
    @JsonProperty("isTrimSpecified")
    public final boolean isTrimSpecified;
    @JsonProperty("videoTrimEndTimeMs")
    public final int videoTrimEndTimeMs;
    @JsonProperty("videoTirmStartTimeMs")
    public final int videoTrimStartTimeMs;

    /* compiled from: suggestions is null at index  */
    final class C02181 implements Creator<VideoTrimParams> {
        C02181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            Object obj = null;
            try {
                obj = VideoTrimParams.m4746a(parcel.readString());
            } catch (Throwable e) {
                BLog.b(VideoTrimParams.class, "Unable to deserialize class from parcel", e);
            }
            return obj;
        }

        public final Object[] newArray(int i) {
            return new VideoTrimParams[i];
        }
    }

    /* compiled from: suggestions is null at index  */
    public class Builder {
        public boolean f3539a = false;
        public int f3540b = -1;
        public int f3541c = -1;

        public final Builder m4744a(int i, int i2) {
            this.f3540b = i;
            this.f3541c = i2;
            boolean z = (i == -1 && i2 == -1) ? false : true;
            this.f3539a = z;
            return this;
        }

        public final VideoTrimParams m4745a() {
            return new VideoTrimParams(this);
        }
    }

    private VideoTrimParams() {
        this.isTrimSpecified = false;
        this.videoTrimStartTimeMs = -1;
        this.videoTrimEndTimeMs = -1;
    }

    public VideoTrimParams(Builder builder) {
        this.isTrimSpecified = builder.f3539a;
        this.videoTrimStartTimeMs = builder.f3540b;
        this.videoTrimEndTimeMs = builder.f3541c;
    }

    private String m4747a() {
        return FbObjectMapper.i().a(this);
    }

    public static VideoTrimParams m4746a(String str) {
        return (VideoTrimParams) FbObjectMapper.i().a(str, VideoTrimParams.class);
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(m4747a());
        } catch (JsonProcessingException e) {
            BLog.b(VideoTrimParams.class, "Unable to serialize class to write to parcel", e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
