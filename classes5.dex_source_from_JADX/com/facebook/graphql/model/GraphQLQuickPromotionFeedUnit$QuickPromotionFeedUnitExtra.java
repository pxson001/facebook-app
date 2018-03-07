package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: VIEW_PAGE_NOTIFICATION_STORY */
public class GraphQLQuickPromotionFeedUnit$QuickPromotionFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLQuickPromotionFeedUnit$QuickPromotionFeedUnitExtra> CREATOR = new C11941();

    /* compiled from: VIEW_PAGE_NOTIFICATION_STORY */
    final class C11941 implements Creator<GraphQLQuickPromotionFeedUnit$QuickPromotionFeedUnitExtra> {
        C11941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuickPromotionFeedUnit$QuickPromotionFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuickPromotionFeedUnit$QuickPromotionFeedUnitExtra[i];
        }
    }

    protected GraphQLQuickPromotionFeedUnit$QuickPromotionFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
