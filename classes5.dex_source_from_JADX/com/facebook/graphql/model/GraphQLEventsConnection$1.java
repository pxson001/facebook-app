package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: imageLow */
final class GraphQLEventsConnection$1 implements Creator<GraphQLEventsConnection> {
    GraphQLEventsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventsConnection[i];
    }
}
