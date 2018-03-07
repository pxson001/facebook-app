package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ios_page_header */
final class GraphQLEditAction$1 implements Creator<GraphQLEditAction> {
    GraphQLEditAction$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEditAction(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEditAction[i];
    }
}
