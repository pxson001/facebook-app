package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: has_viewer_viewed */
final class GraphQLFriendingPossibilitiesConnection$1 implements Creator<GraphQLFriendingPossibilitiesConnection> {
    GraphQLFriendingPossibilitiesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFriendingPossibilitiesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFriendingPossibilitiesConnection[i];
    }
}
