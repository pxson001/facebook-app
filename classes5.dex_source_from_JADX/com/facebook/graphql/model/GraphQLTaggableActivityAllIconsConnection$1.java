package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UNSUB */
final class GraphQLTaggableActivityAllIconsConnection$1 implements Creator<GraphQLTaggableActivityAllIconsConnection> {
    GraphQLTaggableActivityAllIconsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTaggableActivityAllIconsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTaggableActivityAllIconsConnection[i];
    }
}
