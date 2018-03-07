package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: initial_view_roll_degrees */
final class GraphQLEventHostsConnection$1 implements Creator<GraphQLEventHostsConnection> {
    GraphQLEventHostsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventHostsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventHostsConnection[i];
    }
}
