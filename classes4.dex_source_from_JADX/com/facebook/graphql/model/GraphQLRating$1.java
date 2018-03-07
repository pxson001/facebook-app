package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user_disabled */
final class GraphQLRating$1 implements Creator<GraphQLRating> {
    GraphQLRating$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLRating(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLRating[i];
    }
}
