package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: enable_ranked_replies */
final class GraphQLPagePostPromotionInfo$1 implements Creator<GraphQLPagePostPromotionInfo> {
    GraphQLPagePostPromotionInfo$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPagePostPromotionInfo(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPagePostPromotionInfo[i];
    }
}
