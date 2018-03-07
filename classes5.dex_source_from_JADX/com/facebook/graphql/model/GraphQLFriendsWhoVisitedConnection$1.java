package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: harmonization_employee_curation */
final class GraphQLFriendsWhoVisitedConnection$1 implements Creator<GraphQLFriendsWhoVisitedConnection> {
    GraphQLFriendsWhoVisitedConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFriendsWhoVisitedConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFriendsWhoVisitedConnection[i];
    }
}
