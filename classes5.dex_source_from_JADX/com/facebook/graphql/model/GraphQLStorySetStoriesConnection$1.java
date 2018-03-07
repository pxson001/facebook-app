package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: USER_SETTING */
final class GraphQLStorySetStoriesConnection$1 implements Creator<GraphQLStorySetStoriesConnection> {
    GraphQLStorySetStoriesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStorySetStoriesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStorySetStoriesConnection[i];
    }
}
