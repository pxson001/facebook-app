package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UNIVERSAL_FEEDBACK */
final class GraphQLTimelineAppSection$1 implements Creator<GraphQLTimelineAppSection> {
    GraphQLTimelineAppSection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTimelineAppSection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTimelineAppSection[i];
    }
}
