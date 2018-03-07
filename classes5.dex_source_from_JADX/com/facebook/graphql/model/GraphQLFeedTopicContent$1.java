package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: hovercard */
final class GraphQLFeedTopicContent$1 implements Creator<GraphQLFeedTopicContent> {
    GraphQLFeedTopicContent$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFeedTopicContent(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFeedTopicContent[i];
    }
}
