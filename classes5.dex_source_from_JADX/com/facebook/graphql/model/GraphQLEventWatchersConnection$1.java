package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: imagePortrait */
final class GraphQLEventWatchersConnection$1 implements Creator<GraphQLEventWatchersConnection> {
    GraphQLEventWatchersConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventWatchersConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventWatchersConnection[i];
    }
}
