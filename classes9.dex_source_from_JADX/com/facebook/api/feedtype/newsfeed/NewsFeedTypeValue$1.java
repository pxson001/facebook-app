package com.facebook.api.feedtype.newsfeed;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UPGRADE_ONLY */
final class NewsFeedTypeValue$1 implements Creator<NewsFeedTypeValue> {
    NewsFeedTypeValue$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new NewsFeedTypeValue(parcel);
    }

    public final Object[] newArray(int i) {
        return new NewsFeedTypeValue[i];
    }
}
