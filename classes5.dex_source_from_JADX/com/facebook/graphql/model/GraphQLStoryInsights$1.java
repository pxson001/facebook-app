package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Unable to create thumbnail bitmap. */
final class GraphQLStoryInsights$1 implements Creator<GraphQLStoryInsights> {
    GraphQLStoryInsights$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStoryInsights(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStoryInsights[i];
    }
}
