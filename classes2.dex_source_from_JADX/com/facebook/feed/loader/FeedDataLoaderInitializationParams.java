package com.facebook.feed.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: friending_block_multiple_users */
public class FeedDataLoaderInitializationParams implements Parcelable {
    public static final Creator<FeedDataLoaderInitializationParams> CREATOR = new 1();
    public int f23128a;

    public FeedDataLoaderInitializationParams(Parcel parcel) {
        this.f23128a = parcel.readInt();
    }

    public FeedDataLoaderInitializationParams(Builder builder) {
        this.f23128a = builder.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f23128a);
    }
}
