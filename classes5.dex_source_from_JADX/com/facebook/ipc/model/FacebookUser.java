package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = FacebookUserDeserializer.class)
@Deprecated
/* compiled from: TEXT_LINK */
public class FacebookUser implements Parcelable {
    public static final Creator<FacebookUser> CREATOR = new C13601();
    private static final Class<?> f14129a = FacebookUser.class;
    @JsonProperty("pic_cover")
    @Nullable
    public final FacebookUserCoverPhoto mCoverPhoto;
    @JsonProperty("name")
    public String mDisplayName;
    @JsonProperty("first_name")
    public final String mFirstName;
    @JsonProperty("pic_square")
    public final String mImageUrl;
    @JsonProperty("last_name")
    public final String mLastName;
    @JsonProperty("uid")
    public final long mUserId;

    /* compiled from: TEXT_LINK */
    final class C13601 implements Creator<FacebookUser> {
        C13601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookUser(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookUser[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public FacebookUser(Parcel parcel) {
        this.mUserId = parcel.readLong();
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mDisplayName = parcel.readString();
        this.mImageUrl = parcel.readString();
        this.mCoverPhoto = (FacebookUserCoverPhoto) parcel.readParcelable(FacebookUserCoverPhoto.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUserId);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mDisplayName);
        parcel.writeParcelable(this.mCoverPhoto, i);
    }

    public FacebookUser(long j, String str, String str2, String str3, String str4, @Nullable FacebookUserCoverPhoto facebookUserCoverPhoto) {
        this.mUserId = j;
        this.mFirstName = str;
        this.mLastName = str2;
        this.mDisplayName = str3;
        this.mImageUrl = str4;
        this.mCoverPhoto = facebookUserCoverPhoto;
    }

    protected FacebookUser() {
        this.mUserId = -1;
        this.mFirstName = null;
        this.mLastName = null;
        this.mDisplayName = null;
        this.mImageUrl = null;
        this.mCoverPhoto = null;
    }

    public final String m23506a() {
        if (this.mDisplayName != null) {
            return this.mDisplayName;
        }
        BLog.b(f14129a, "display name was requested, but is null");
        return "";
    }

    public String toString() {
        return Objects.toStringHelper(getClass()).add("display name", this.mDisplayName).add("uid", this.mUserId).toString();
    }
}
