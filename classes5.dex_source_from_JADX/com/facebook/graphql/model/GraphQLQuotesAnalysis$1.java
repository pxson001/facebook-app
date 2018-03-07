package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIEW_GUEST_LIST */
final class GraphQLQuotesAnalysis$1 implements Creator<GraphQLQuotesAnalysis> {
    GraphQLQuotesAnalysis$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLQuotesAnalysis(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLQuotesAnalysis[i];
    }
}
