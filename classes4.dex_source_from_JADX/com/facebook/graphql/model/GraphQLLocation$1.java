package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user_display_name */
final class GraphQLLocation$1 implements Creator<GraphQLLocation> {
    GraphQLLocation$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLocation(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLocation[i];
    }
}
