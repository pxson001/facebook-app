package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UNLABELED_LINE_CHART */
final class GraphQLTimeRange$1 implements Creator<GraphQLTimeRange> {
    GraphQLTimeRange$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTimeRange(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTimeRange[i];
    }
}
