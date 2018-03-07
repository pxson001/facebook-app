package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: This instance has been unsubscribed and the queue is no longer usable. */
final class GraphQLVideoGuidedTour$1 implements Creator<GraphQLVideoGuidedTour> {
    GraphQLVideoGuidedTour$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLVideoGuidedTour(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLVideoGuidedTour[i];
    }
}
