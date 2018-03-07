package com.facebook.platform.server.handler;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: fetch_topic_feed */
public class ParcelableString implements Parcelable {
    public String f14934a;

    public ParcelableString(String str) {
        this.f14934a = str;
    }

    public final String m22539a() {
        return this.f14934a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14934a);
    }
}
