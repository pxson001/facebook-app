package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friend_description */
final class GraphQLGroupMembersConnection$1 implements Creator<GraphQLGroupMembersConnection> {
    GraphQLGroupMembersConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGroupMembersConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGroupMembersConnection[i];
    }
}
