package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UP */
final class GraphQLSurveyFeedUnit$1 implements Creator<GraphQLSurveyFeedUnit> {
    GraphQLSurveyFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLSurveyFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLSurveyFeedUnit[i];
    }
}
