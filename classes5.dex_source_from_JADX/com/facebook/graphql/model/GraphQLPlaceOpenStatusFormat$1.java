package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WEATHER_CONDITION_ALERT */
final class GraphQLPlaceOpenStatusFormat$1 implements Creator<GraphQLPlaceOpenStatusFormat> {
    GraphQLPlaceOpenStatusFormat$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPlaceOpenStatusFormat(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPlaceOpenStatusFormat[i];
    }
}
