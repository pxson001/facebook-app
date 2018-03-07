package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: feed_chaining */
final class GraphQLLeadGenUserStatus$1 implements Creator<GraphQLLeadGenUserStatus> {
    GraphQLLeadGenUserStatus$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLeadGenUserStatus(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLeadGenUserStatus[i];
    }
}
