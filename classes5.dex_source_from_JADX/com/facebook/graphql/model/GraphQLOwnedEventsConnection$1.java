package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: error_text */
final class GraphQLOwnedEventsConnection$1 implements Creator<GraphQLOwnedEventsConnection> {
    GraphQLOwnedEventsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLOwnedEventsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLOwnedEventsConnection[i];
    }
}
