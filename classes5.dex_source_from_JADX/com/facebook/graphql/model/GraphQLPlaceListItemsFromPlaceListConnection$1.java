package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WEATHER_FORECAST */
final class GraphQLPlaceListItemsFromPlaceListConnection$1 implements Creator<GraphQLPlaceListItemsFromPlaceListConnection> {
    GraphQLPlaceListItemsFromPlaceListConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPlaceListItemsFromPlaceListConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPlaceListItemsFromPlaceListConnection[i];
    }
}
