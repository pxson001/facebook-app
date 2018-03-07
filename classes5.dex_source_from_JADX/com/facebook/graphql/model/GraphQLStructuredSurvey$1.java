package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: USERNAME */
final class GraphQLStructuredSurvey$1 implements Creator<GraphQLStructuredSurvey> {
    GraphQLStructuredSurvey$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLStructuredSurvey(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLStructuredSurvey[i];
    }
}
