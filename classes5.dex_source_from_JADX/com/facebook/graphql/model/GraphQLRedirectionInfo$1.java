package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIDEO_ONLY */
final class GraphQLRedirectionInfo$1 implements Creator<GraphQLRedirectionInfo> {
    GraphQLRedirectionInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLRedirectionInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLRedirectionInfo[i];
    }
}
