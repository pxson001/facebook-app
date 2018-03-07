package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: scheduler_timer */
final class GraphQLInterestingRepliesConnection$1 implements Creator<GraphQLInterestingRepliesConnection> {
    GraphQLInterestingRepliesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInterestingRepliesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInterestingRepliesConnection[i];
    }
}
