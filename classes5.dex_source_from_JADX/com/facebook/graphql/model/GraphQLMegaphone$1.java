package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: failed_status */
final class GraphQLMegaphone$1 implements Creator<GraphQLMegaphone> {
    GraphQLMegaphone$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLMegaphone(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLMegaphone[i];
    }
}
