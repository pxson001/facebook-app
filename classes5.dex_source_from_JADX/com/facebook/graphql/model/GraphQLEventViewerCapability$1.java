package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: imageSmallSquare */
final class GraphQLEventViewerCapability$1 implements Creator<GraphQLEventViewerCapability> {
    GraphQLEventViewerCapability$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventViewerCapability(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventViewerCapability[i];
    }
}
