package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: icon_dominant_color */
final class GraphQLExternalUrl$1 implements Creator<GraphQLExternalUrl> {
    GraphQLExternalUrl$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLExternalUrl(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLExternalUrl[i];
    }
}
