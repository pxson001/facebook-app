package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: group_leaderboard */
final class GraphQLGeoRectangle$1 implements Creator<GraphQLGeoRectangle> {
    GraphQLGeoRectangle$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGeoRectangle(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGeoRectangle[i];
    }
}
