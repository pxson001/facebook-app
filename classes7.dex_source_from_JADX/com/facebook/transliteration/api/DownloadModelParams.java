package com.facebook.transliteration.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: expected header type  */
public class DownloadModelParams implements Parcelable {
    public final int f15148a;
    public final int f15149b;
    public final int f15150c;
    public final int f15151d;

    public DownloadModelParams(int i, int i2, boolean z, int i3) {
        this.f15148a = i;
        this.f15149b = i2;
        this.f15150c = z ? 1 : 0;
        this.f15151d = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15148a);
        parcel.writeInt(this.f15149b);
        parcel.writeInt(this.f15150c);
        parcel.writeInt(this.f15151d);
    }
}
