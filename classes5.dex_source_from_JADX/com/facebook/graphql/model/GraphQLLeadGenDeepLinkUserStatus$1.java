package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: feed_topic_content */
final class GraphQLLeadGenDeepLinkUserStatus$1 implements Creator<GraphQLLeadGenDeepLinkUserStatus> {
    GraphQLLeadGenDeepLinkUserStatus$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLeadGenDeepLinkUserStatus(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLeadGenDeepLinkUserStatus[i];
    }
}
