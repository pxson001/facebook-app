package com.facebook.rtc.campon;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = RtcCamperModelDeserializer.class)
/* compiled from: audio_clips_recording_failed */
public class RtcCamperModel implements Parcelable {
    public static final Creator<RtcCamperModel> CREATOR = new C22871();
    @JsonProperty("camp_type")
    public final int mCampType;
    @JsonProperty("peer_first_name")
    public final String mPeerFirstName;
    @JsonProperty("peer_id")
    public final long mPeerId;
    @JsonProperty("peer_name")
    public final String mPeerName;
    @JsonProperty("start_time_ms")
    public final long mStartTimeMs;
    @JsonProperty("wait_time_ms")
    public final long mWaitTimeMs;

    /* compiled from: audio_clips_recording_failed */
    final class C22871 implements Creator<RtcCamperModel> {
        C22871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RtcCamperModel(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
        }

        public final Object[] newArray(int i) {
            return new RtcCamperModel[i];
        }
    }

    public RtcCamperModel() {
        this.mCampType = 0;
        this.mPeerId = 0;
        this.mPeerFirstName = null;
        this.mPeerName = null;
        this.mStartTimeMs = 0;
        this.mWaitTimeMs = 0;
    }

    public RtcCamperModel(int i, long j, String str, String str2, long j2, long j3) {
        this.mCampType = i;
        this.mPeerId = j;
        this.mPeerFirstName = str;
        this.mPeerName = str2;
        this.mStartTimeMs = j2;
        this.mWaitTimeMs = j3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCampType);
        parcel.writeLong(this.mPeerId);
        parcel.writeString(this.mPeerFirstName);
        parcel.writeString(this.mPeerName);
        parcel.writeLong(this.mStartTimeMs);
        parcel.writeLong(this.mWaitTimeMs);
    }
}
