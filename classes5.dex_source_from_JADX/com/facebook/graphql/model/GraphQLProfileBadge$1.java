package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VOIP */
final class GraphQLProfileBadge$1 implements Creator<GraphQLProfileBadge> {
    GraphQLProfileBadge$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLProfileBadge(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLProfileBadge[i];
    }
}
