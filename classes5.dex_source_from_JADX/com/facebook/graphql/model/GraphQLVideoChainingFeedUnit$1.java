package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TimeRange */
final class GraphQLVideoChainingFeedUnit$1 implements Creator<GraphQLVideoChainingFeedUnit> {
    GraphQLVideoChainingFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLVideoChainingFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLVideoChainingFeedUnit[i];
    }
}
