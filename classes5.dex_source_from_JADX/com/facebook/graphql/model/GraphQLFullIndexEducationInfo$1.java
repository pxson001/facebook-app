package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: gyscItems */
final class GraphQLFullIndexEducationInfo$1 implements Creator<GraphQLFullIndexEducationInfo> {
    GraphQLFullIndexEducationInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFullIndexEducationInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFullIndexEducationInfo[i];
    }
}
