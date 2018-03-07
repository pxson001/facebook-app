package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user_enabled */
final class GraphQLStreetAddress$1 implements Creator<GraphQLStreetAddress> {
    GraphQLStreetAddress$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStreetAddress(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStreetAddress[i];
    }
}
