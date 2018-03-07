package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FacebookEventDeserializer.class)
/* compiled from: TEXT_WITH_INLINE_FACEPILE */
public class FacebookEvent implements Parcelable {
    public static final Creator<FacebookEvent> CREATOR = new C13561();
    private static final Class<?> f14120a = FacebookEvent.class;
    @JsonProperty("end_time")
    protected long mEndTime;
    @JsonProperty("eid")
    protected long mEventId;
    @JsonProperty("name")
    protected String mName;
    @JsonProperty("pic_square")
    protected String mPicSquare;
    @JsonProperty("start_time")
    protected long mStartTime;

    /* compiled from: TEXT_WITH_INLINE_FACEPILE */
    final class C13561 implements Creator<FacebookEvent> {
        C13561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookEvent(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookEvent[i];
        }
    }

    public FacebookEvent() {
        this.mEventId = -1;
        this.mName = null;
        this.mPicSquare = null;
    }

    public int describeContents() {
        return 0;
    }

    protected FacebookEvent(Parcel parcel) {
        this.mEventId = parcel.readLong();
        this.mName = parcel.readString();
        this.mPicSquare = parcel.readString();
        this.mStartTime = parcel.readLong();
        this.mEndTime = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mEventId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mPicSquare);
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mEndTime);
    }

    public boolean equals(Object obj) {
        return (obj instanceof FacebookEvent) && m23494a((FacebookEvent) obj);
    }

    private boolean m23494a(FacebookEvent facebookEvent) {
        return this.mEventId == facebookEvent.mEventId;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.mEventId)});
    }

    public String toString() {
        return Objects.toStringHelper(FacebookEvent.class).add("id", this.mEventId).add("name", this.mName).add("pic", this.mPicSquare).add("start", this.mStartTime).add("end", this.mEndTime).toString();
    }
}
