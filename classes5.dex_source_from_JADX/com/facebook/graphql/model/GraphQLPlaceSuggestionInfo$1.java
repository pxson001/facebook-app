package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WATCHED_RECOMMENDATIONS */
final class GraphQLPlaceSuggestionInfo$1 implements Creator<GraphQLPlaceSuggestionInfo> {
    GraphQLPlaceSuggestionInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPlaceSuggestionInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPlaceSuggestionInfo[i];
    }
}
