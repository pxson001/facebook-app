package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: fact_time */
final class GraphQLMessengerContentSubscriptionOption$1 implements Creator<GraphQLMessengerContentSubscriptionOption> {
    GraphQLMessengerContentSubscriptionOption$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLMessengerContentSubscriptionOption(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLMessengerContentSubscriptionOption[i];
    }
}
