package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user_alerted_ */
final class GraphQLPageVisitsConnection$1 implements Creator<GraphQLPageVisitsConnection> {
    GraphQLPageVisitsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPageVisitsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPageVisitsConnection[i];
    }
}
