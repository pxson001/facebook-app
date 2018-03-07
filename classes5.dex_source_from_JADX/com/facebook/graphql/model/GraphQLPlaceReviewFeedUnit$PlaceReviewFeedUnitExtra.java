package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: WATERFALL */
public class GraphQLPlaceReviewFeedUnit$PlaceReviewFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLPlaceReviewFeedUnit$PlaceReviewFeedUnitExtra> CREATOR = new C11801();

    /* compiled from: WATERFALL */
    final class C11801 implements Creator<GraphQLPlaceReviewFeedUnit$PlaceReviewFeedUnitExtra> {
        C11801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlaceReviewFeedUnit$PlaceReviewFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlaceReviewFeedUnit$PlaceReviewFeedUnitExtra[i];
        }
    }

    protected GraphQLPlaceReviewFeedUnit$PlaceReviewFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
