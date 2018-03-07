package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: original_is_prefetch */
final class GraphQLEvent$1 implements Creator<GraphQLEvent> {
    GraphQLEvent$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEvent(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEvent[i];
    }
}
