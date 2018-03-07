package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: game_about */
final class GraphQLGraphSearchQueryTitle$1 implements Creator<GraphQLGraphSearchQueryTitle> {
    GraphQLGraphSearchQueryTitle$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLGraphSearchQueryTitle(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLGraphSearchQueryTitle[i];
    }
}
