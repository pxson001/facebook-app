package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: hc_reminder_birthday */
final class GraphQLFriendListFeedConnection$1 implements Creator<GraphQLFriendListFeedConnection> {
    GraphQLFriendListFeedConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFriendListFeedConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFriendListFeedConnection[i];
    }
}
