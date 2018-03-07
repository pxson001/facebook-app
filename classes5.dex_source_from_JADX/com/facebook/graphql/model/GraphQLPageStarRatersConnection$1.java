package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: enable_feedback_for_reply_previews */
final class GraphQLPageStarRatersConnection$1 implements Creator<GraphQLPageStarRatersConnection> {
    GraphQLPageStarRatersConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPageStarRatersConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPageStarRatersConnection[i];
    }
}
