package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WEAKLYENGAGED_BY_YOUR_FRIENDS */
final class GraphQLPlaceRecommendationPostInfo$1 implements Creator<GraphQLPlaceRecommendationPostInfo> {
    GraphQLPlaceRecommendationPostInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPlaceRecommendationPostInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPlaceRecommendationPostInfo[i];
    }
}
