package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: enabled_favorite_icon */
final class GraphQLPageOutcomeButton$1 implements Creator<GraphQLPageOutcomeButton> {
    GraphQLPageOutcomeButton$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPageOutcomeButton(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPageOutcomeButton[i];
    }
}
