package com.facebook.platform.auth.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: location_required_not_working */
public class ExtendAccessTokenMethod$Result implements Parcelable {
    public static final Creator<ExtendAccessTokenMethod$Result> CREATOR = new C12631();
    public final String f8465a;
    public final long f8466b;

    /* compiled from: location_required_not_working */
    final class C12631 implements Creator<ExtendAccessTokenMethod$Result> {
        C12631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ExtendAccessTokenMethod$Result(parcel);
        }

        public final Object[] newArray(int i) {
            return new ExtendAccessTokenMethod$Result[i];
        }
    }

    public ExtendAccessTokenMethod$Result(String str, long j) {
        this.f8465a = str;
        this.f8466b = j;
    }

    public ExtendAccessTokenMethod$Result(Parcel parcel) {
        this.f8465a = parcel.readString();
        this.f8466b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8465a);
        parcel.writeLong(this.f8466b);
    }
}
