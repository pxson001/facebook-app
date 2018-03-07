package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: has_ad_conversion_pixel_domain */
final class GraphQLFriendsWhoLikeConnection$1 implements Creator<GraphQLFriendsWhoLikeConnection> {
    GraphQLFriendsWhoLikeConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFriendsWhoLikeConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFriendsWhoLikeConnection[i];
    }
}
