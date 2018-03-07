package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: image_unblock_for_dialtone */
final class GraphQLEventTicketProvider$1 implements Creator<GraphQLEventTicketProvider> {
    GraphQLEventTicketProvider$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventTicketProvider(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventTicketProvider[i];
    }
}
