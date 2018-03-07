package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: feedback_unsubscribe */
final class GraphQLInstreamVideoAdsConnection$1 implements Creator<GraphQLInstreamVideoAdsConnection> {
    GraphQLInstreamVideoAdsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInstreamVideoAdsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInstreamVideoAdsConnection[i];
    }
}
