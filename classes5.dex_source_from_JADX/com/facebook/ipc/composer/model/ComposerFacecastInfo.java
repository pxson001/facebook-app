package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.video.videostreaming.protocol.VideoBroadcastInitResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerFacecastInfoDeserializer.class)
@JsonSerialize(using = ComposerFacecastInfoSerializer.class)
/* compiled from: TOGGLE_BUTTON */
public class ComposerFacecastInfo implements Parcelable {
    public static final Creator<ComposerFacecastInfo> CREATOR = new C13271();
    @JsonProperty("facecast_camera_index")
    public final int facecastCameraIndex;
    @JsonProperty("facecast_camera_zoom_level")
    public final int facecastCameraZoomLevel;
    @JsonProperty("is_facecast_ready")
    public final boolean isFacecastReady;
    @JsonProperty("refetch_broadcast_id")
    public final boolean shouldRefetchBroadcastId;
    @JsonProperty("video_broadcast_response")
    @Nullable
    public final VideoBroadcastInitResponse videoBroadcastInitResponse;

    /* compiled from: TOGGLE_BUTTON */
    final class C13271 implements Creator<ComposerFacecastInfo> {
        C13271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerFacecastInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerFacecastInfo[i];
        }
    }

    /* compiled from: TOGGLE_BUTTON */
    public class Builder {
        public int f13942a = -1;
        public int f13943b = 0;
        public boolean f13944c = false;
        @Nullable
        public VideoBroadcastInitResponse f13945d;
        public boolean f13946e = false;

        public Builder(ComposerFacecastInfo composerFacecastInfo) {
            this.f13942a = composerFacecastInfo.facecastCameraIndex;
            this.f13943b = composerFacecastInfo.facecastCameraZoomLevel;
            this.f13944c = composerFacecastInfo.isFacecastReady;
            this.f13945d = composerFacecastInfo.videoBroadcastInitResponse;
            this.f13946e = composerFacecastInfo.shouldRefetchBroadcastId;
        }

        public final ComposerFacecastInfo m23305a() {
            return new ComposerFacecastInfo(this);
        }
    }

    @JsonIgnore
    private ComposerFacecastInfo() {
        this(new Builder());
    }

    public ComposerFacecastInfo(Builder builder) {
        this.facecastCameraIndex = builder.f13942a;
        this.facecastCameraZoomLevel = builder.f13943b;
        this.isFacecastReady = builder.f13944c;
        this.videoBroadcastInitResponse = builder.f13945d;
        this.shouldRefetchBroadcastId = builder.f13946e;
    }

    public ComposerFacecastInfo(Parcel parcel) {
        this.facecastCameraIndex = parcel.readInt();
        this.facecastCameraZoomLevel = parcel.readInt();
        this.isFacecastReady = ParcelUtil.m3827a(parcel);
        this.videoBroadcastInitResponse = (VideoBroadcastInitResponse) parcel.readParcelable(VideoBroadcastInitResponse.class.getClassLoader());
        this.shouldRefetchBroadcastId = ParcelUtil.m3827a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.facecastCameraIndex);
        parcel.writeInt(this.facecastCameraZoomLevel);
        ParcelUtil.m3826a(parcel, this.isFacecastReady);
        parcel.writeParcelable(this.videoBroadcastInitResponse, i);
        ParcelUtil.m3826a(parcel, this.shouldRefetchBroadcastId);
    }
}
