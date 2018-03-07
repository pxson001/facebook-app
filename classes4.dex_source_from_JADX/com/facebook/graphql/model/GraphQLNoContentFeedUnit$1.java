package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: other_sd */
final class GraphQLNoContentFeedUnit$1 implements Creator<GraphQLNoContentFeedUnit> {
    GraphQLNoContentFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLNoContentFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLNoContentFeedUnit[i];
    }
}
