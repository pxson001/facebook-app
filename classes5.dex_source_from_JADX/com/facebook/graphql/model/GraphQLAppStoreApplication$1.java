package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: item_availability */
final class GraphQLAppStoreApplication$1 implements Creator<GraphQLAppStoreApplication> {
    GraphQLAppStoreApplication$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAppStoreApplication(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAppStoreApplication[i];
    }
}
