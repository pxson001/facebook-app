package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: in_progress */
final class GraphQLEventMembersConnection$1 implements Creator<GraphQLEventMembersConnection> {
    GraphQLEventMembersConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventMembersConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventMembersConnection[i];
    }
}
