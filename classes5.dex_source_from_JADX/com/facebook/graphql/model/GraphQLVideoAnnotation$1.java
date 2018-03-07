package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TimelineAppCollection */
final class GraphQLVideoAnnotation$1 implements Creator<GraphQLVideoAnnotation> {
    GraphQLVideoAnnotation$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLVideoAnnotation(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLVideoAnnotation[i];
    }
}
