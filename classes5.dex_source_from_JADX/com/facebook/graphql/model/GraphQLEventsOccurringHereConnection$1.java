package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: imageLarge */
final class GraphQLEventsOccurringHereConnection$1 implements Creator<GraphQLEventsOccurringHereConnection> {
    GraphQLEventsOccurringHereConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventsOccurringHereConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventsOccurringHereConnection[i];
    }
}
