package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.Postprocessable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = FacebookProfileDeserializer.class)
@JsonSerialize(using = FacebookProfileSerializer.class)
/* compiled from: TEXT_MULTILINE_CHAR_LIMIT */
public class FacebookProfile implements Parcelable, Postprocessable<FacebookProfile> {
    public static final Creator<FacebookProfile> CREATOR = new C13591();
    public int f14127a;
    @JsonProperty("name")
    public final String mDisplayName;
    @JsonProperty("id")
    public final long mId;
    @JsonProperty("pic_square")
    public final String mImageUrl;
    @JsonProperty("type")
    String mTypeString;

    /* compiled from: TEXT_MULTILINE_CHAR_LIMIT */
    final class C13591 implements Creator<FacebookProfile> {
        C13591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookProfile(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookProfile[i];
        }
    }

    public FacebookProfile() {
        this.mId = -1;
        this.mDisplayName = null;
        this.mImageUrl = null;
        this.f14127a = 0;
    }

    public FacebookProfile(long j, String str, String str2, int i) {
        this.mId = j;
        this.mDisplayName = str;
        this.mImageUrl = str2;
        this.f14127a = i;
    }

    public FacebookProfile(long j, String str) {
        this.mId = j;
        this.mDisplayName = str;
        this.mImageUrl = null;
        this.f14127a = 0;
    }

    public int describeContents() {
        return 0;
    }

    protected FacebookProfile(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mDisplayName = parcel.readString();
        this.mImageUrl = parcel.readString();
        this.f14127a = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeString(this.mDisplayName);
        parcel.writeString(this.mImageUrl);
        parcel.writeInt(this.f14127a);
    }

    public int hashCode() {
        return (int) this.mId;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FacebookProfile(").append(this.mDisplayName).append(" (id=").append(this.mId).append("))");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof FacebookProfile) && this.mId == ((FacebookProfile) obj).mId;
    }

    public final Object m23501a() {
        if (this.mTypeString != null) {
            if (this.mTypeString.equals("page")) {
                this.f14127a = 1;
            } else if (this.mTypeString.equals("group")) {
                this.f14127a = 3;
            } else if (this.mTypeString.equals("event")) {
                this.f14127a = 4;
            }
        }
        this.mTypeString = null;
        return this;
    }
}
