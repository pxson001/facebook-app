package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VACATION_HOME_RENTAL */
final class GraphQLSinglePublisherVideoChannelsConnection$1 implements Creator<GraphQLSinglePublisherVideoChannelsConnection> {
    GraphQLSinglePublisherVideoChannelsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSinglePublisherVideoChannelsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSinglePublisherVideoChannelsConnection[i];
    }
}
