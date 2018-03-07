package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UriSerializer.serialize */
final class GraphQLSouvenirMediaConnection$1 implements Creator<GraphQLSouvenirMediaConnection> {
    GraphQLSouvenirMediaConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSouvenirMediaConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSouvenirMediaConnection[i];
    }
}
