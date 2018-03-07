package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: family_search */
final class GraphQLMediaSet$1 implements Creator<GraphQLMediaSet> {
    GraphQLMediaSet$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLMediaSet(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLMediaSet[i];
    }
}
