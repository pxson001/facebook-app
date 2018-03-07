package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: image_overlays */
final class GraphQLEventTimeRange$1 implements Creator<GraphQLEventTimeRange> {
    GraphQLEventTimeRange$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventTimeRange(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventTimeRange[i];
    }
}
