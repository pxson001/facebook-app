package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: estimated_reach */
final class GraphQLOverlayCallToActionInfo$1 implements Creator<GraphQLOverlayCallToActionInfo> {
    GraphQLOverlayCallToActionInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLOverlayCallToActionInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLOverlayCallToActionInfo[i];
    }
}
