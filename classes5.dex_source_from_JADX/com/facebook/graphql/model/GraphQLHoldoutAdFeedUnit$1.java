package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: forceCodeForRefreshToken */
final class GraphQLHoldoutAdFeedUnit$1 implements Creator<GraphQLHoldoutAdFeedUnit> {
    GraphQLHoldoutAdFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLHoldoutAdFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLHoldoutAdFeedUnit[i];
    }
}
