package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Unknown */
final class GraphQLStatelessLargeImagePLAsConnection$1 implements Creator<GraphQLStatelessLargeImagePLAsConnection> {
    GraphQLStatelessLargeImagePLAsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStatelessLargeImagePLAsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStatelessLargeImagePLAsConnection[i];
    }
}
