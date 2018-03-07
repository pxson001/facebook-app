package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friendEventMembers */
final class GraphQLGroupTopStoriesFeedUnit$1 implements Creator<GraphQLGroupTopStoriesFeedUnit> {
    GraphQLGroupTopStoriesFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGroupTopStoriesFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGroupTopStoriesFeedUnit[i];
    }
}
