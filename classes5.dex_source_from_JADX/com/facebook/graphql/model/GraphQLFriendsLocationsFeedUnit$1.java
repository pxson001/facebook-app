package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: has_comprehensive_title */
final class GraphQLFriendsLocationsFeedUnit$1 implements Creator<GraphQLFriendsLocationsFeedUnit> {
    GraphQLFriendsLocationsFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFriendsLocationsFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFriendsLocationsFeedUnit[i];
    }
}
