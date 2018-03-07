package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TrueTopicFeedOptionsEdge */
final class GraphQLTranslationMetaData$1 implements Creator<GraphQLTranslationMetaData> {
    GraphQLTranslationMetaData$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTranslationMetaData(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTranslationMetaData[i];
    }
}
