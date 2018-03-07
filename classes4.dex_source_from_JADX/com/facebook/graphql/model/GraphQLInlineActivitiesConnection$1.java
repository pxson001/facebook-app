package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user_account_nux_shown */
final class GraphQLInlineActivitiesConnection$1 implements Creator<GraphQLInlineActivitiesConnection> {
    GraphQLInlineActivitiesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInlineActivitiesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInlineActivitiesConnection[i];
    }
}
