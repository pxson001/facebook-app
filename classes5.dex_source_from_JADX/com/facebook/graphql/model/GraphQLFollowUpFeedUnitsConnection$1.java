package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: hdAtomSize */
final class GraphQLFollowUpFeedUnitsConnection$1 implements Creator<GraphQLFollowUpFeedUnitsConnection> {
    GraphQLFollowUpFeedUnitsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFollowUpFeedUnitsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFollowUpFeedUnitsConnection[i];
    }
}
