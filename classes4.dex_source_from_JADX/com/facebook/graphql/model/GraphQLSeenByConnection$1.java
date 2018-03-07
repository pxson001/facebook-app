package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: screen_brightness_raw_value */
final class GraphQLSeenByConnection$1 implements Creator<GraphQLSeenByConnection> {
    GraphQLSeenByConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSeenByConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSeenByConnection[i];
    }
}
