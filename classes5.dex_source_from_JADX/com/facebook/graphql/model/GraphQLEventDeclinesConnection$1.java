package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: inline_actions */
final class GraphQLEventDeclinesConnection$1 implements Creator<GraphQLEventDeclinesConnection> {
    GraphQLEventDeclinesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventDeclinesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventDeclinesConnection[i];
    }
}
