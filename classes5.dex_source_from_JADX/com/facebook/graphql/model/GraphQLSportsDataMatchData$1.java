package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Unmatched second part of surrogate pair (0x */
final class GraphQLSportsDataMatchData$1 implements Creator<GraphQLSportsDataMatchData> {
    GraphQLSportsDataMatchData$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSportsDataMatchData(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSportsDataMatchData[i];
    }
}
