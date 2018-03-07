package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: event_buy_ticket_url */
final class GraphQLOpenGraphAction$1 implements Creator<GraphQLOpenGraphAction> {
    GraphQLOpenGraphAction$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLOpenGraphAction(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLOpenGraphAction[i];
    }
}
