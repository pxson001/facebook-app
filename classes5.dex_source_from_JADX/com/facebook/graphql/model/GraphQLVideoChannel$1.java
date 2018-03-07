package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Tigon */
final class GraphQLVideoChannel$1 implements Creator<GraphQLVideoChannel> {
    GraphQLVideoChannel$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLVideoChannel(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLVideoChannel[i];
    }
}
