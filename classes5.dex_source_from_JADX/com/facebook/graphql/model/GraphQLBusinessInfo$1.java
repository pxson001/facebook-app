package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_game */
final class GraphQLBusinessInfo$1 implements Creator<GraphQLBusinessInfo> {
    GraphQLBusinessInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLBusinessInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLBusinessInfo[i];
    }
}
