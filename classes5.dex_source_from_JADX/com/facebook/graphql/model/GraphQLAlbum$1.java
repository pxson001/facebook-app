package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: job_tag */
final class GraphQLAlbum$1 implements Creator<GraphQLAlbum> {
    GraphQLAlbum$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAlbum(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAlbum[i];
    }
}
