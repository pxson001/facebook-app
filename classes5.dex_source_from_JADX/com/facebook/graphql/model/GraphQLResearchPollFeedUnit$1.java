package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIDEO_HOME_PINNED_TOPICS_LIVE */
final class GraphQLResearchPollFeedUnit$1 implements Creator<GraphQLResearchPollFeedUnit> {
    GraphQLResearchPollFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLResearchPollFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLResearchPollFeedUnit[i];
    }
}
