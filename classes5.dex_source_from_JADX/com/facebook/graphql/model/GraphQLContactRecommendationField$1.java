package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: isExplicitLocation */
final class GraphQLContactRecommendationField$1 implements Creator<GraphQLContactRecommendationField> {
    GraphQLContactRecommendationField$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLContactRecommendationField(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLContactRecommendationField[i];
    }
}
