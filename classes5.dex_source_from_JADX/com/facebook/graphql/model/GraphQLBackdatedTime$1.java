package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_persistent */
final class GraphQLBackdatedTime$1 implements Creator<GraphQLBackdatedTime> {
    GraphQLBackdatedTime$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLBackdatedTime(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLBackdatedTime[i];
    }
}
