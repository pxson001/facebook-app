package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ios_feather */
final class GraphQLEligibleClashUnitsConnection$1 implements Creator<GraphQLEligibleClashUnitsConnection> {
    GraphQLEligibleClashUnitsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEligibleClashUnitsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEligibleClashUnitsConnection[i];
    }
}
