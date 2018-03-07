package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: feed_type_name */
final class GraphQLLeadGenData$1 implements Creator<GraphQLLeadGenData> {
    GraphQLLeadGenData$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLeadGenData(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLeadGenData[i];
    }
}
