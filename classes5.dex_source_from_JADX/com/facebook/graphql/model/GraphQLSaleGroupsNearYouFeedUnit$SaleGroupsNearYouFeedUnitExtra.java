package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: VIDEO_ANNOTATION */
public class GraphQLSaleGroupsNearYouFeedUnit$SaleGroupsNearYouFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLSaleGroupsNearYouFeedUnit$SaleGroupsNearYouFeedUnitExtra> CREATOR = new C12141();

    /* compiled from: VIDEO_ANNOTATION */
    final class C12141 implements Creator<GraphQLSaleGroupsNearYouFeedUnit$SaleGroupsNearYouFeedUnitExtra> {
        C12141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSaleGroupsNearYouFeedUnit$SaleGroupsNearYouFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSaleGroupsNearYouFeedUnit$SaleGroupsNearYouFeedUnitExtra[i];
        }
    }

    protected GraphQLSaleGroupsNearYouFeedUnit$SaleGroupsNearYouFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
