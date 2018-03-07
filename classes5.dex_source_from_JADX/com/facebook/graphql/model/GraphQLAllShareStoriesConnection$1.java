package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: java.util */
final class GraphQLAllShareStoriesConnection$1 implements Creator<GraphQLAllShareStoriesConnection> {
    GraphQLAllShareStoriesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAllShareStoriesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAllShareStoriesConnection[i];
    }
}
