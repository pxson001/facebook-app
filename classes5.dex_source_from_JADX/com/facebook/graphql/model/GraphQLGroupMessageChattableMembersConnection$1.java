package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friend_center_friends */
final class GraphQLGroupMessageChattableMembersConnection$1 implements Creator<GraphQLGroupMessageChattableMembersConnection> {
    GraphQLGroupMessageChattableMembersConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGroupMessageChattableMembersConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGroupMessageChattableMembersConnection[i];
    }
}
