package com.facebook.messaging.media.imageurirequest;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: is_free */
public class FetchImageParams implements Parcelable {
    public final String f12075a;
    public final int f12076b;

    public FetchImageParams(String str, int i) {
        this.f12075a = str;
        this.f12076b = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12075a);
        parcel.writeInt(this.f12076b);
    }
}
