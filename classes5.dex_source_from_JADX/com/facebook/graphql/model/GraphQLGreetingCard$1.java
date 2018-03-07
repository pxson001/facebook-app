package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: full_address */
final class GraphQLGreetingCard$1 implements Creator<GraphQLGreetingCard> {
    GraphQLGreetingCard$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGreetingCard(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGreetingCard[i];
    }
}
