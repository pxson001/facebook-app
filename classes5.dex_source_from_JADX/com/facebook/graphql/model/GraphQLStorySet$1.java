package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UTF-8 */
final class GraphQLStorySet$1 implements Creator<GraphQLStorySet> {
    GraphQLStorySet$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStorySet(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStorySet[i];
    }
}
