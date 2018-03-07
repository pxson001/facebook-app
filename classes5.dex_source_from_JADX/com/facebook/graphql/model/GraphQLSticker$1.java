package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Unexpected HTTP code  */
final class GraphQLSticker$1 implements Creator<GraphQLSticker> {
    GraphQLSticker$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSticker(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSticker[i];
    }
}
