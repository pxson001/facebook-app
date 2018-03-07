package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: header_image */
final class GraphQLFindPagesFeedUnit$1 implements Creator<GraphQLFindPagesFeedUnit> {
    GraphQLFindPagesFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFindPagesFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFindPagesFeedUnit[i];
    }
}
