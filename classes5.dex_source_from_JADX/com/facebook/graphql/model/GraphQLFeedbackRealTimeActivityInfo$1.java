package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: hideStory */
final class GraphQLFeedbackRealTimeActivityInfo$1 implements Creator<GraphQLFeedbackRealTimeActivityInfo> {
    GraphQLFeedbackRealTimeActivityInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFeedbackRealTimeActivityInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFeedbackRealTimeActivityInfo[i];
    }
}
