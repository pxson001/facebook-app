package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: finch_more */
final class GraphQLInlineStyleAtRange$1 implements Creator<GraphQLInlineStyleAtRange> {
    GraphQLInlineStyleAtRange$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInlineStyleAtRange(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInlineStyleAtRange[i];
    }
}
