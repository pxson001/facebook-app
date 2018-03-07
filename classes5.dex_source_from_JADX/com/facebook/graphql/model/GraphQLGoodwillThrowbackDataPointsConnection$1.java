package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: google.message_id */
final class GraphQLGoodwillThrowbackDataPointsConnection$1 implements Creator<GraphQLGoodwillThrowbackDataPointsConnection> {
    GraphQLGoodwillThrowbackDataPointsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGoodwillThrowbackDataPointsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGoodwillThrowbackDataPointsConnection[i];
    }
}
