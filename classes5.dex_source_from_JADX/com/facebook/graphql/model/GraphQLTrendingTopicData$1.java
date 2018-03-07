package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TrendingEntitiesEdge */
final class GraphQLTrendingTopicData$1 implements Creator<GraphQLTrendingTopicData> {
    GraphQLTrendingTopicData$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTrendingTopicData(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTrendingTopicData[i];
    }
}
