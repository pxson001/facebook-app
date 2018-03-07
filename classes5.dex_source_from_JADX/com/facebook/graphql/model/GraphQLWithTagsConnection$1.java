package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TargetingDescription */
final class GraphQLWithTagsConnection$1 implements Creator<GraphQLWithTagsConnection> {
    GraphQLWithTagsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLWithTagsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLWithTagsConnection[i];
    }
}
