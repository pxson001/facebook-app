package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: entity_with_image */
final class GraphQLPageAdminInfo$1 implements Creator<GraphQLPageAdminInfo> {
    GraphQLPageAdminInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPageAdminInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPageAdminInfo[i];
    }
}
