package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ffa */
final class GraphQLInstantArticleVersion$1 implements Creator<GraphQLInstantArticleVersion> {
    GraphQLInstantArticleVersion$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLInstantArticleVersion(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLInstantArticleVersion[i];
    }
}
