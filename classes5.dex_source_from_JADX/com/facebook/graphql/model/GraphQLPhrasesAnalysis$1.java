package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WHITELIST_AND_RELOAD_UNIT */
final class GraphQLPhrasesAnalysis$1 implements Creator<GraphQLPhrasesAnalysis> {
    GraphQLPhrasesAnalysis$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPhrasesAnalysis(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPhrasesAnalysis[i];
    }
}
