package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: oxygen_map_dynamic_map_stats_per_impression */
final class GraphQLTopic$1 implements Creator<GraphQLTopic> {
    GraphQLTopic$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTopic(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTopic[i];
    }
}
