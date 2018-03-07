package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: engagement_pyml */
final class GraphQLPageCallToAction$1 implements Creator<GraphQLPageCallToAction> {
    GraphQLPageCallToAction$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPageCallToAction(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPageCallToAction[i];
    }
}
