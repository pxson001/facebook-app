package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: feed_story_search */
final class GraphQLLeadGenErrorNode$1 implements Creator<GraphQLLeadGenErrorNode> {
    GraphQLLeadGenErrorNode$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLLeadGenErrorNode(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLLeadGenErrorNode[i];
    }
}
