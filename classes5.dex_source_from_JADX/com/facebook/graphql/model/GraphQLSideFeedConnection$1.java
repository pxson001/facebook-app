package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VERTEX_ADD_A_CATEGORY */
final class GraphQLSideFeedConnection$1 implements Creator<GraphQLSideFeedConnection> {
    GraphQLSideFeedConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSideFeedConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSideFeedConnection[i];
    }
}
