package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: hybrid */
final class GraphQLFaceBoxTagSuggestionsConnection$1 implements Creator<GraphQLFaceBoxTagSuggestionsConnection> {
    GraphQLFaceBoxTagSuggestionsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFaceBoxTagSuggestionsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFaceBoxTagSuggestionsConnection[i];
    }
}
