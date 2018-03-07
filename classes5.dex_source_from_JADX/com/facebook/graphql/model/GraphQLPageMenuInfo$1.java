package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: encryptChannelRequestMethod */
final class GraphQLPageMenuInfo$1 implements Creator<GraphQLPageMenuInfo> {
    GraphQLPageMenuInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPageMenuInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPageMenuInfo[i];
    }
}
