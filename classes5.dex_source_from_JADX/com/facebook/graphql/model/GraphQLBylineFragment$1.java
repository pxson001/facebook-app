package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_explicit_location */
final class GraphQLBylineFragment$1 implements Creator<GraphQLBylineFragment> {
    GraphQLBylineFragment$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLBylineFragment(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLBylineFragment[i];
    }
}
