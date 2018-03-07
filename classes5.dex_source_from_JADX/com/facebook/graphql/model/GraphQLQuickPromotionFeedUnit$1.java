package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: VIEW_PAGE_NOTIFICATION_STORY */
final class GraphQLQuickPromotionFeedUnit$1 implements Creator<GraphQLQuickPromotionFeedUnit> {
    GraphQLQuickPromotionFeedUnit$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLQuickPromotionFeedUnit(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLQuickPromotionFeedUnit[i];
    }
}
