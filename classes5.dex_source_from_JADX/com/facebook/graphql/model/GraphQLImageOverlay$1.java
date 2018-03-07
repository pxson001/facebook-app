package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: focus */
final class GraphQLImageOverlay$1 implements Creator<GraphQLImageOverlay> {
    GraphQLImageOverlay$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLImageOverlay(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLImageOverlay[i];
    }
}
