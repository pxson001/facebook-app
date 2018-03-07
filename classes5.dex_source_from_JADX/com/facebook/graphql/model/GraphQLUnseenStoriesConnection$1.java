package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Total bluetooth usage  */
final class GraphQLUnseenStoriesConnection$1 implements Creator<GraphQLUnseenStoriesConnection> {
    GraphQLUnseenStoriesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLUnseenStoriesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLUnseenStoriesConnection[i];
    }
}
