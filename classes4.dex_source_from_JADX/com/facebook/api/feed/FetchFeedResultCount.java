package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: non_cached_preferences_db */
public class FetchFeedResultCount implements Parcelable {
    public final int f7019a;
    public final FetchFeedParams f7020b;

    public FetchFeedResultCount(FetchFeedParams fetchFeedParams, int i) {
        this.f7020b = fetchFeedParams;
        this.f7019a = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7019a);
    }
}
