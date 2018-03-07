package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: help_center_url */
final class GraphQLFindFriendsFeedUnit$1 implements Creator<GraphQLFindFriendsFeedUnit> {
    GraphQLFindFriendsFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFindFriendsFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFindFriendsFeedUnit[i];
    }
}
