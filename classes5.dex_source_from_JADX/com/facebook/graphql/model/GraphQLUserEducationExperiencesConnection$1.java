package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Topic */
final class GraphQLUserEducationExperiencesConnection$1 implements Creator<GraphQLUserEducationExperiencesConnection> {
    GraphQLUserEducationExperiencesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLUserEducationExperiencesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLUserEducationExperiencesConnection[i];
    }
}
