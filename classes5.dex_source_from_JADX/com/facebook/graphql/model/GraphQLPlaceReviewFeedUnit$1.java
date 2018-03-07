package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WATERFALL */
final class GraphQLPlaceReviewFeedUnit$1 implements Creator<GraphQLPlaceReviewFeedUnit> {
    GraphQLPlaceReviewFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPlaceReviewFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPlaceReviewFeedUnit[i];
    }
}
