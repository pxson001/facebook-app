package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: isIncompleteData */
final class GraphQLContact$1 implements Creator<GraphQLContact> {
    GraphQLContact$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLContact(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLContact[i];
    }
}
