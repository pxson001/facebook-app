package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIDEO_LIST */
final class GraphQLRelevantReactorsConnection$1 implements Creator<GraphQLRelevantReactorsConnection> {
    GraphQLRelevantReactorsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLRelevantReactorsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLRelevantReactorsConnection[i];
    }
}
