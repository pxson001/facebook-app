package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: eventType= */
final class GraphQLOpenGraphObject$1 implements Creator<GraphQLOpenGraphObject> {
    GraphQLOpenGraphObject$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLOpenGraphObject(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLOpenGraphObject[i];
    }
}
