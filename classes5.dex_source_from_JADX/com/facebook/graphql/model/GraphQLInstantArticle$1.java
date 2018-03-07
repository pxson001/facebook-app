package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: fieldAssignmentFormatter */
final class GraphQLInstantArticle$1 implements Creator<GraphQLInstantArticle> {
    GraphQLInstantArticle$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInstantArticle(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInstantArticle[i];
    }
}
