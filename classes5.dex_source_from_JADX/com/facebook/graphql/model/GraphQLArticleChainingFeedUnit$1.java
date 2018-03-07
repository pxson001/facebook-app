package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_spherical */
final class GraphQLArticleChainingFeedUnit$1 implements Creator<GraphQLArticleChainingFeedUnit> {
    GraphQLArticleChainingFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLArticleChainingFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLArticleChainingFeedUnit[i];
    }
}
