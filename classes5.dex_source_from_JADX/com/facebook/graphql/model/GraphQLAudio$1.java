package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_playable */
final class GraphQLAudio$1 implements Creator<GraphQLAudio> {
    GraphQLAudio$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAudio(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAudio[i];
    }
}
