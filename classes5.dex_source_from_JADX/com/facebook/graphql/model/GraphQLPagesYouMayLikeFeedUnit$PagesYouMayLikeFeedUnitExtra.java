package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: eglInitialize */
public class GraphQLPagesYouMayLikeFeedUnit$PagesYouMayLikeFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLPagesYouMayLikeFeedUnit$PagesYouMayLikeFeedUnitExtra> CREATOR = new C04661();

    /* compiled from: eglInitialize */
    final class C04661 implements Creator<GraphQLPagesYouMayLikeFeedUnit$PagesYouMayLikeFeedUnitExtra> {
        C04661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPagesYouMayLikeFeedUnit$PagesYouMayLikeFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPagesYouMayLikeFeedUnit$PagesYouMayLikeFeedUnitExtra[i];
        }
    }

    protected GraphQLPagesYouMayLikeFeedUnit$PagesYouMayLikeFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
