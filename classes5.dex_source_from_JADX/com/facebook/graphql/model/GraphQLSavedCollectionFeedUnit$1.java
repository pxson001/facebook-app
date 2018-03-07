package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VETERINARIAN */
final class GraphQLSavedCollectionFeedUnit$1 implements Creator<GraphQLSavedCollectionFeedUnit> {
    GraphQLSavedCollectionFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSavedCollectionFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSavedCollectionFeedUnit[i];
    }
}
