package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: oxygen_map_dynamic_map_view_impression */
final class GraphQLStoryTopicsContext$1 implements Creator<GraphQLStoryTopicsContext> {
    GraphQLStoryTopicsContext$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStoryTopicsContext(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStoryTopicsContext[i];
    }
}
