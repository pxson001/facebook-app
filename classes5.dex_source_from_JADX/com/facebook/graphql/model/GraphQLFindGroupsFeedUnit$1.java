package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: headline_source */
final class GraphQLFindGroupsFeedUnit$1 implements Creator<GraphQLFindGroupsFeedUnit> {
    GraphQLFindGroupsFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFindGroupsFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFindGroupsFeedUnit[i];
    }
}
