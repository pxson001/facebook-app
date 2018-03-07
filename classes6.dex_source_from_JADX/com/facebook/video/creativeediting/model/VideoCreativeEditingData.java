package com.facebook.video.creativeediting.model;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = VideoCreativeEditingDataDeserializer.class)
@JsonSerialize(using = VideoCreativeEditingDataSerializer.class)
/* compiled from: contact_id = ? */
public class VideoCreativeEditingData implements Parcelable {
    public static final Creator<VideoCreativeEditingData> CREATOR = new C13821();
    @JsonProperty("crop_rect_bottom")
    final float mCropRectBottom;
    @JsonProperty("crop_rect_left")
    final float mCropRectLeft;
    @JsonProperty("crop_rect_right")
    final float mCropRectRight;
    @JsonProperty("crop_rect_specified")
    final boolean mCropRectSpecified;
    @JsonProperty("crop_rect_top")
    final float mCropRectTop;
    @JsonProperty("display_uri")
    final String mDisplayUri;
    @JsonProperty("is_muted")
    final boolean mIsVideoMuted;
    @JsonProperty("overlay_id")
    final String mOverlayId;
    @JsonProperty("overlay_uri")
    final String mOverlayUri;
    @JsonProperty("rotation_angle")
    final int mRotationAngle;
    @JsonProperty("should_flip_horizontally")
    final boolean mShouldFlipHorizontally;
    @JsonProperty("video_trim_params")
    final VideoTrimParams mTrimParams;

    /* compiled from: contact_id = ? */
    final class C13821 implements Creator<VideoCreativeEditingData> {
        C13821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoCreativeEditingData(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoCreativeEditingData[i];
        }
    }

    /* compiled from: contact_id = ? */
    public class Builder {
        public VideoTrimParams f18623a;
        public int f18624b;
        public boolean f18625c;
        public String f18626d;
        public RectF f18627e;
        public String f18628f;
        public String f18629g;
        public boolean f18630h;

        public Builder() {
            this.f18623a = null;
            this.f18624b = 0;
            this.f18625c = false;
            this.f18626d = null;
            this.f18627e = null;
            this.f18628f = null;
            this.f18629g = null;
            this.f18630h = false;
        }

        public Builder(VideoCreativeEditingData videoCreativeEditingData) {
            this.f18623a = videoCreativeEditingData.mTrimParams;
            this.f18624b = videoCreativeEditingData.mRotationAngle;
            this.f18625c = videoCreativeEditingData.mIsVideoMuted;
            this.f18626d = videoCreativeEditingData.mDisplayUri;
            this.f18627e = videoCreativeEditingData.m27390e();
            this.f18628f = videoCreativeEditingData.mOverlayUri;
            this.f18629g = videoCreativeEditingData.mOverlayId;
            this.f18630h = videoCreativeEditingData.mShouldFlipHorizontally;
        }

        public final VideoCreativeEditingData m27385a() {
            return new VideoCreativeEditingData(this);
        }
    }

    private VideoCreativeEditingData() {
        this(new Builder());
    }

    public VideoCreativeEditingData(Builder builder) {
        this.mTrimParams = builder.f18623a;
        this.mRotationAngle = builder.f18624b;
        this.mIsVideoMuted = builder.f18625c;
        this.mDisplayUri = builder.f18626d;
        if (builder.f18627e != null) {
            this.mCropRectSpecified = true;
            this.mCropRectLeft = builder.f18627e.left;
            this.mCropRectRight = builder.f18627e.right;
            this.mCropRectTop = builder.f18627e.top;
            this.mCropRectBottom = builder.f18627e.bottom;
        } else {
            this.mCropRectSpecified = false;
            this.mCropRectLeft = 0.0f;
            this.mCropRectRight = 0.0f;
            this.mCropRectTop = 0.0f;
            this.mCropRectBottom = 0.0f;
        }
        this.mOverlayUri = builder.f18628f;
        this.mOverlayId = builder.f18629g;
        if (this.mOverlayUri != null) {
            Preconditions.checkNotNull(this.mOverlayId);
        }
        this.mShouldFlipHorizontally = builder.f18630h;
    }

    public VideoCreativeEditingData(Parcel parcel) {
        this.mTrimParams = (VideoTrimParams) parcel.readParcelable(VideoTrimParams.class.getClassLoader());
        this.mRotationAngle = parcel.readInt();
        this.mIsVideoMuted = ParcelUtil.a(parcel);
        this.mDisplayUri = parcel.readString();
        this.mCropRectSpecified = ParcelUtil.a(parcel);
        this.mCropRectLeft = parcel.readFloat();
        this.mCropRectRight = parcel.readFloat();
        this.mCropRectTop = parcel.readFloat();
        this.mCropRectBottom = parcel.readFloat();
        this.mOverlayUri = parcel.readString();
        this.mOverlayId = parcel.readString();
        this.mShouldFlipHorizontally = ParcelUtil.a(parcel);
    }

    @JsonIgnore
    public final VideoTrimParams m27386a() {
        return this.mTrimParams;
    }

    @JsonIgnore
    public final int m27387b() {
        return this.mRotationAngle;
    }

    @JsonIgnore
    public final boolean m27388c() {
        return this.mIsVideoMuted;
    }

    @JsonIgnore
    public final String m27389d() {
        return this.mDisplayUri;
    }

    @JsonIgnore
    public final RectF m27390e() {
        if (this.mCropRectSpecified) {
            return new RectF(this.mCropRectLeft, this.mCropRectTop, this.mCropRectRight, this.mCropRectBottom);
        }
        return null;
    }

    @JsonIgnore
    public final String m27391f() {
        return this.mOverlayUri;
    }

    @JsonIgnore
    public final String m27392g() {
        return this.mOverlayId;
    }

    @JsonIgnore
    public final boolean m27393h() {
        return this.mShouldFlipHorizontally;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mTrimParams, i);
        parcel.writeInt(this.mRotationAngle);
        ParcelUtil.a(parcel, this.mIsVideoMuted);
        parcel.writeString(this.mDisplayUri);
        ParcelUtil.a(parcel, this.mCropRectSpecified);
        parcel.writeFloat(this.mCropRectLeft);
        parcel.writeFloat(this.mCropRectRight);
        parcel.writeFloat(this.mCropRectTop);
        parcel.writeFloat(this.mCropRectBottom);
        parcel.writeString(this.mOverlayUri);
        parcel.writeString(this.mOverlayId);
        ParcelUtil.a(parcel, this.mShouldFlipHorizontally);
    }

    public final int m27394i() {
        return this.mTrimParams.videoTrimEndTimeMs - this.mTrimParams.videoTrimStartTimeMs;
    }
}
