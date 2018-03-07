package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: has_photo_menus */
final class GraphQLFriendsConnection$1 implements Creator<GraphQLFriendsConnection> {
    GraphQLFriendsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFriendsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFriendsConnection[i];
    }
}
