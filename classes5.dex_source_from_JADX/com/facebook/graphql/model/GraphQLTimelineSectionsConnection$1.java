package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UNDO_BUTTON */
final class GraphQLTimelineSectionsConnection$1 implements Creator<GraphQLTimelineSectionsConnection> {
    GraphQLTimelineSectionsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTimelineSectionsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTimelineSectionsConnection[i];
    }
}
