package com.facebook.contacts.graphql;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ContactPhoneDeserializer.class)
@Immutable
@JsonSerialize(using = ContactPhoneSerializer.class)
/* compiled from: photo-exif */
public class ContactPhone implements Parcelable {
    public static final Creator<ContactPhone> CREATOR = new C05101();
    @JsonProperty("displayNumber")
    final String mDisplayNumber;
    @JsonProperty("id")
    final String mId;
    @JsonProperty("isVerified")
    final boolean mIsVerified;
    @JsonProperty("label")
    final String mLabel;
    @JsonProperty("universalNumber")
    final String mUniversalNumber;

    /* compiled from: photo-exif */
    final class C05101 implements Creator<ContactPhone> {
        C05101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactPhone(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactPhone[i];
        }
    }

    public ContactPhone(String str, String str2, String str3, String str4, boolean z) {
        this.mId = str;
        this.mLabel = str2;
        this.mDisplayNumber = str3;
        this.mUniversalNumber = str4;
        this.mIsVerified = z;
    }

    private ContactPhone() {
        this.mId = null;
        this.mLabel = null;
        this.mDisplayNumber = null;
        this.mUniversalNumber = null;
        this.mIsVerified = false;
    }

    public ContactPhone(Parcel parcel) {
        boolean z = true;
        this.mId = parcel.readString();
        this.mLabel = parcel.readString();
        this.mDisplayNumber = parcel.readString();
        this.mUniversalNumber = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mIsVerified = z;
    }

    public final String m12028a() {
        return this.mId;
    }

    public final String m12029b() {
        return this.mLabel;
    }

    public final String m12030c() {
        return this.mDisplayNumber;
    }

    public final String m12031d() {
        return this.mUniversalNumber;
    }

    public final boolean m12032e() {
        return this.mIsVerified;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mLabel);
        parcel.writeString(this.mDisplayNumber);
        parcel.writeString(this.mUniversalNumber);
        parcel.writeInt(this.mIsVerified ? 1 : 0);
    }

    public String toString() {
        return "ContactPhone<" + this.mId + ":" + this.mLabel + "> " + this.mUniversalNumber + " (" + this.mDisplayNumber + ")";
    }
}
