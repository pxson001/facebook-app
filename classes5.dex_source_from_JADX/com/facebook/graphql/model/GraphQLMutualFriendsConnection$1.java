package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: facebookSignInOptions */
final class GraphQLMutualFriendsConnection$1 implements Creator<GraphQLMutualFriendsConnection> {
    GraphQLMutualFriendsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLMutualFriendsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLMutualFriendsConnection[i];
    }
}
