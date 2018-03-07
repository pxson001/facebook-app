package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: The max capacity  */
final class GraphQLVideoTimestampedCommentsConnection$1 implements Creator<GraphQLVideoTimestampedCommentsConnection> {
    GraphQLVideoTimestampedCommentsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLVideoTimestampedCommentsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLVideoTimestampedCommentsConnection[i];
    }
}
