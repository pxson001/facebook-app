package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: frames_cta */
final class GraphQLGroupsYouShouldCreateFeedUnit$1 implements Creator<GraphQLGroupsYouShouldCreateFeedUnit> {
    GraphQLGroupsYouShouldCreateFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGroupsYouShouldCreateFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGroupsYouShouldCreateFeedUnit[i];
    }
}
