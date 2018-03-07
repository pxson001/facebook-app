package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UNDERAGE_FAN_REMOVAL */
final class GraphQLTimelineStoriesConnection$1 implements Creator<GraphQLTimelineStoriesConnection> {
    GraphQLTimelineStoriesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTimelineStoriesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTimelineStoriesConnection[i];
    }
}
