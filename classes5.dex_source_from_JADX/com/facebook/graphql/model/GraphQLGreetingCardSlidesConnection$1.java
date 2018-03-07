package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friends_who_visited */
final class GraphQLGreetingCardSlidesConnection$1 implements Creator<GraphQLGreetingCardSlidesConnection> {
    GraphQLGreetingCardSlidesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGreetingCardSlidesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGreetingCardSlidesConnection[i];
    }
}
