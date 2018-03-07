package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friends_invited */
final class GraphQLGroup$1 implements Creator<GraphQLGroup> {
    GraphQLGroup$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGroup(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGroup[i];
    }
}
