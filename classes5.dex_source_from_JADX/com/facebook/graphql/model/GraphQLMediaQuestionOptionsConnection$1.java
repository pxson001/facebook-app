package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: fb4a_graphql_disk_cache_snapshot_table */
final class GraphQLMediaQuestionOptionsConnection$1 implements Creator<GraphQLMediaQuestionOptionsConnection> {
    GraphQLMediaQuestionOptionsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLMediaQuestionOptionsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLMediaQuestionOptionsConnection[i];
    }
}
