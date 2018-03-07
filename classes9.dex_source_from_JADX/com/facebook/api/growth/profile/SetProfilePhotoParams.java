package com.facebook.api.growth.profile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: sendMessage */
public class SetProfilePhotoParams implements Parcelable {
    public static final Creator<SetProfilePhotoParams> CREATOR = new C03691();
    public final long f4049a;
    public final String f4050b;
    public final String f4051c;
    public final String f4052d;

    /* compiled from: sendMessage */
    final class C03691 implements Creator<SetProfilePhotoParams> {
        C03691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetProfilePhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetProfilePhotoParams[i];
        }
    }

    public SetProfilePhotoParams(long j, String str) {
        this(j, str, null, null);
    }

    public SetProfilePhotoParams(long j, String str, String str2, String str3) {
        this.f4049a = j;
        this.f4050b = str;
        this.f4051c = str2;
        this.f4052d = str3;
    }

    public SetProfilePhotoParams(Parcel parcel) {
        this.f4049a = parcel.readLong();
        this.f4050b = parcel.readString();
        this.f4051c = parcel.readString();
        this.f4052d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4049a);
        parcel.writeString(this.f4050b);
        parcel.writeString(this.f4051c);
        parcel.writeString(this.f4052d);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("method", "SetProfilePhotoMethod").add("profileId", this.f4049a).add("photoFilePath", this.f4050b).add("profilePhotoSource", this.f4051c).add("profilePhotoMethod", this.f4052d).toString();
    }
}
