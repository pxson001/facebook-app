package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WITHIN_FEW_HOURS */
final class GraphQLPhoneNumber$1 implements Creator<GraphQLPhoneNumber> {
    GraphQLPhoneNumber$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPhoneNumber(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPhoneNumber[i];
    }
}
