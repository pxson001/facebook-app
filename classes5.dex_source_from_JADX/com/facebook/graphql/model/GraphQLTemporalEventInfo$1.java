package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UNOWNED_PAGE_ACTION_MENU_REPORT_PAGE */
final class GraphQLTemporalEventInfo$1 implements Creator<GraphQLTemporalEventInfo> {
    GraphQLTemporalEventInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTemporalEventInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTemporalEventInfo[i];
    }
}
