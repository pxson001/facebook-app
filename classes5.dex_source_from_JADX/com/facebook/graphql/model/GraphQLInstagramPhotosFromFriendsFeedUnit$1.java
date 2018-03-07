package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: filtered_claim_count */
final class GraphQLInstagramPhotosFromFriendsFeedUnit$1 implements Creator<GraphQLInstagramPhotosFromFriendsFeedUnit> {
    GraphQLInstagramPhotosFromFriendsFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInstagramPhotosFromFriendsFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInstagramPhotosFromFriendsFeedUnit[i];
    }
}
