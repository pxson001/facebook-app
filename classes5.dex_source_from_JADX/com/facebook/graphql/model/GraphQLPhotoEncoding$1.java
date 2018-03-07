package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WINERY_VINEYARD */
final class GraphQLPhotoEncoding$1 implements Creator<GraphQLPhotoEncoding> {
    GraphQLPhotoEncoding$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPhotoEncoding(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPhotoEncoding[i];
    }
}
