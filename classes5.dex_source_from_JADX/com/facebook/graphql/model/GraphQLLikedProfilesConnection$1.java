package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: feed_ad */
final class GraphQLLikedProfilesConnection$1 implements Creator<GraphQLLikedProfilesConnection> {
    GraphQLLikedProfilesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLikedProfilesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLikedProfilesConnection[i];
    }
}
