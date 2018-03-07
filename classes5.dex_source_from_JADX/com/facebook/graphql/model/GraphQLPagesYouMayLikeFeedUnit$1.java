package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: eglInitialize */
final class GraphQLPagesYouMayLikeFeedUnit$1 implements Creator<GraphQLPagesYouMayLikeFeedUnit> {
    GraphQLPagesYouMayLikeFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPagesYouMayLikeFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPagesYouMayLikeFeedUnit[i];
    }
}
