package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: prev_user_logout_time */
final class GraphQLCustomizedStory$1 implements Creator<GraphQLCustomizedStory> {
    GraphQLCustomizedStory$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLCustomizedStory(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLCustomizedStory[i];
    }
}
