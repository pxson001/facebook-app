package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user_meta_context */
final class GraphQLTimelineAppCollection$1 implements Creator<GraphQLTimelineAppCollection> {
    GraphQLTimelineAppCollection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTimelineAppCollection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTimelineAppCollection[i];
    }
}
