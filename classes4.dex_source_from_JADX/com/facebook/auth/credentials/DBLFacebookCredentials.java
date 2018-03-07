package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.infer.annotation.PrivacySource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = DBLFacebookCredentialsDeserializer.class)
/* compiled from: preview_uri */
public class DBLFacebookCredentials implements Parcelable {
    public static final Creator<DBLFacebookCredentials> CREATOR = new C01991();
    @JsonProperty("is_pin_set")
    public final Boolean mIsPinSet;
    @PrivacySource
    @JsonProperty("name")
    public final String mName;
    @PrivacySource
    @JsonProperty("nonce")
    public final String mNonce;
    @PrivacySource
    @JsonProperty("pic_url")
    public final String mPicUrl;
    @JsonProperty("time")
    public final int mTime;
    @PrivacySource
    @JsonProperty("uid")
    public final String mUserId;
    @PrivacySource
    @JsonProperty("username")
    public final String mUsername;

    /* compiled from: preview_uri */
    final class C01991 implements Creator<DBLFacebookCredentials> {
        C01991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DBLFacebookCredentials(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ParcelUtil.a(parcel));
        }

        public final Object[] newArray(int i) {
            return new DBLFacebookCredentials[i];
        }
    }

    public DBLFacebookCredentials() {
        this.mUserId = null;
        this.mTime = 0;
        this.mName = null;
        this.mUsername = null;
        this.mPicUrl = null;
        this.mNonce = null;
        this.mIsPinSet = Boolean.valueOf(false);
    }

    public DBLFacebookCredentials(String str, int i, String str2, String str3, String str4, String str5, boolean z) {
        this.mUserId = str;
        this.mTime = i;
        this.mName = str2;
        this.mUsername = str3;
        this.mPicUrl = str4;
        this.mNonce = str5;
        this.mIsPinSet = Boolean.valueOf(z);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUserId);
        parcel.writeInt(this.mTime);
        parcel.writeString(this.mName);
        parcel.writeString(this.mUsername);
        parcel.writeString(this.mPicUrl);
        parcel.writeString(this.mNonce);
        ParcelUtil.a(parcel, this.mIsPinSet.booleanValue());
    }
}
