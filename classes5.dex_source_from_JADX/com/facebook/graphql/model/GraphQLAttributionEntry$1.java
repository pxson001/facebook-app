package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_save_primary_action */
final class GraphQLAttributionEntry$1 implements Creator<GraphQLAttributionEntry> {
    GraphQLAttributionEntry$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAttributionEntry(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAttributionEntry[i];
    }
}
