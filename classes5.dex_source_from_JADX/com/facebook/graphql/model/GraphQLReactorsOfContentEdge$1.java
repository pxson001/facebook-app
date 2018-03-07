package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIDEO_STORIES */
final class GraphQLReactorsOfContentEdge$1 implements Creator<GraphQLReactorsOfContentEdge> {
    GraphQLReactorsOfContentEdge$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLReactorsOfContentEdge(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLReactorsOfContentEdge[i];
    }
}
