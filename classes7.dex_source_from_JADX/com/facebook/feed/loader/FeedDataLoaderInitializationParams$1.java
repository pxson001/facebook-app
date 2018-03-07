package com.facebook.feed.loader;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: android.intent.action.TIME_SET */
final class FeedDataLoaderInitializationParams$1 implements Creator<FeedDataLoaderInitializationParams> {
    FeedDataLoaderInitializationParams$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new FeedDataLoaderInitializationParams(parcel);
    }

    public final Object[] newArray(int i) {
        return new FeedDataLoaderInitializationParams[i];
    }
}
