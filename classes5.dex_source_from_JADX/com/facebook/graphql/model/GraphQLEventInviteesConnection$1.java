package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: inheritableThreadLocals */
final class GraphQLEventInviteesConnection$1 implements Creator<GraphQLEventInviteesConnection> {
    GraphQLEventInviteesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventInviteesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventInviteesConnection[i];
    }
}
