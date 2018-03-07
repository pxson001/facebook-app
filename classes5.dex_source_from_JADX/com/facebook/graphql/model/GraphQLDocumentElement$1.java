package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ios_place_creation_old_source */
final class GraphQLDocumentElement$1 implements Creator<GraphQLDocumentElement> {
    GraphQLDocumentElement$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLDocumentElement(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLDocumentElement[i];
    }
}
