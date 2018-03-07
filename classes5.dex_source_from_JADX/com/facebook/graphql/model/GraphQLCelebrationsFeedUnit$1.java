package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_editable */
final class GraphQLCelebrationsFeedUnit$1 implements Creator<GraphQLCelebrationsFeedUnit> {
    GraphQLCelebrationsFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLCelebrationsFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLCelebrationsFeedUnit[i];
    }
}
