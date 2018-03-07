package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIDEO_PLAY */
final class GraphQLRedSpaceStoryInfo$1 implements Creator<GraphQLRedSpaceStoryInfo> {
    GraphQLRedSpaceStoryInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLRedSpaceStoryInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLRedSpaceStoryInfo[i];
    }
}
