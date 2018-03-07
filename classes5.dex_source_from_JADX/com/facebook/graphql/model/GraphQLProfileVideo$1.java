package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VOD_FULLSCREEN */
final class GraphQLProfileVideo$1 implements Creator<GraphQLProfileVideo> {
    GraphQLProfileVideo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLProfileVideo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLProfileVideo[i];
    }
}
