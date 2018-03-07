package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: fc_search */
final class GraphQLLinkTargetStoreData$1 implements Creator<GraphQLLinkTargetStoreData> {
    GraphQLLinkTargetStoreData$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLinkTargetStoreData(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLinkTargetStoreData[i];
    }
}
