package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_on_sale */
final class GraphQLBoostedComponent$1 implements Creator<GraphQLBoostedComponent> {
    GraphQLBoostedComponent$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLBoostedComponent(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLBoostedComponent[i];
    }
}
