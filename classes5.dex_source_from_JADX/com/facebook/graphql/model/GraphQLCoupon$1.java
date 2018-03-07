package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: isBackoutDraft */
final class GraphQLCoupon$1 implements Creator<GraphQLCoupon> {
    GraphQLCoupon$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLCoupon(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLCoupon[i];
    }
}
