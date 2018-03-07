package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TimezoneInfo */
final class GraphQLUserWorkExperiencesConnection$1 implements Creator<GraphQLUserWorkExperiencesConnection> {
    GraphQLUserWorkExperiencesConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLUserWorkExperiencesConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLUserWorkExperiencesConnection[i];
    }
}
