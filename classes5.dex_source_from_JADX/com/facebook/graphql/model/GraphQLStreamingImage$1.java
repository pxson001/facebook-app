package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: USER_DISABLED */
final class GraphQLStreamingImage$1 implements Creator<GraphQLStreamingImage> {
    GraphQLStreamingImage$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStreamingImage(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStreamingImage[i];
    }
}
