package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: games_pyml */
final class GraphQLGraphSearchQueryFilterValuesConnection$1 implements Creator<GraphQLGraphSearchQueryFilterValuesConnection> {
    GraphQLGraphSearchQueryFilterValuesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGraphSearchQueryFilterValuesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGraphSearchQueryFilterValuesConnection[i];
    }
}
