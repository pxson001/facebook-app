package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: index value outside legal index range [0.. */
final class GraphQLEventMaybesConnection$1 implements Creator<GraphQLEventMaybesConnection> {
    GraphQLEventMaybesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventMaybesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventMaybesConnection[i];
    }
}
