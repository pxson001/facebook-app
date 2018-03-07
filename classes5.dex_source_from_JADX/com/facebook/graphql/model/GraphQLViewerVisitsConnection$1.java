package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TaskStackBuilder */
final class GraphQLViewerVisitsConnection$1 implements Creator<GraphQLViewerVisitsConnection> {
    GraphQLViewerVisitsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLViewerVisitsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLViewerVisitsConnection[i];
    }
}
