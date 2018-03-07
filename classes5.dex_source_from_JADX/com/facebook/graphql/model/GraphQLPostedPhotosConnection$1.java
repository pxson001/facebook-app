package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ViewerReactionsMutation */
final class GraphQLPostedPhotosConnection$1 implements Creator<GraphQLPostedPhotosConnection> {
    GraphQLPostedPhotosConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPostedPhotosConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPostedPhotosConnection[i];
    }
}
