package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: saved_audio_mode */
final class GraphQLName$1 implements Creator<GraphQLName> {
    GraphQLName$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLName(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLName[i];
    }
}
