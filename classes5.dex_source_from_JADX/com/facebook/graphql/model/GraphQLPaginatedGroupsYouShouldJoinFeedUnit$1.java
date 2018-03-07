package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WRITE_ON_TIMELINE */
final class GraphQLPaginatedGroupsYouShouldJoinFeedUnit$1 implements Creator<GraphQLPaginatedGroupsYouShouldJoinFeedUnit> {
    GraphQLPaginatedGroupsYouShouldJoinFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPaginatedGroupsYouShouldJoinFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPaginatedGroupsYouShouldJoinFeedUnit[i];
    }
}
