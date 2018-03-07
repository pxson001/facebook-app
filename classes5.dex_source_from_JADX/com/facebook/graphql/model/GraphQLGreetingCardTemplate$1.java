package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friends_who_like */
final class GraphQLGreetingCardTemplate$1 implements Creator<GraphQLGreetingCardTemplate> {
    GraphQLGreetingCardTemplate$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGreetingCardTemplate(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGreetingCardTemplate[i];
    }
}
