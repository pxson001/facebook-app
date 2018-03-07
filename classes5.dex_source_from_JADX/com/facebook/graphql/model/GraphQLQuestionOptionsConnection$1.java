package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIEW_PROFILE */
final class GraphQLQuestionOptionsConnection$1 implements Creator<GraphQLQuestionOptionsConnection> {
    GraphQLQuestionOptionsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLQuestionOptionsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLQuestionOptionsConnection[i];
    }
}
