package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ios_report_duplicate */
final class GraphQLCurrencyQuantity$1 implements Creator<GraphQLCurrencyQuantity> {
    GraphQLCurrencyQuantity$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLCurrencyQuantity(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLCurrencyQuantity[i];
    }
}
