package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIDEO_ANNOTATION */
final class GraphQLSaleGroupsNearYouFeedUnit$1 implements Creator<GraphQLSaleGroupsNearYouFeedUnit> {
    GraphQLSaleGroupsNearYouFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSaleGroupsNearYouFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSaleGroupsNearYouFeedUnit[i];
    }
}
