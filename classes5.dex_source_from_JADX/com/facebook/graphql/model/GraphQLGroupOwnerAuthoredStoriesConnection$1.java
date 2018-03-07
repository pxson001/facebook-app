package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: friend_browser */
final class GraphQLGroupOwnerAuthoredStoriesConnection$1 implements Creator<GraphQLGroupOwnerAuthoredStoriesConnection> {
    GraphQLGroupOwnerAuthoredStoriesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGroupOwnerAuthoredStoriesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGroupOwnerAuthoredStoriesConnection[i];
    }
}
