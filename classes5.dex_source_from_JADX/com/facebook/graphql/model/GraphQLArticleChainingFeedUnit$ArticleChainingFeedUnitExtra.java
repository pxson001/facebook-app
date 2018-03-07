package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: is_spherical */
public class GraphQLArticleChainingFeedUnit$ArticleChainingFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLArticleChainingFeedUnit$ArticleChainingFeedUnitExtra> CREATOR = new C02741();

    /* compiled from: is_spherical */
    final class C02741 implements Creator<GraphQLArticleChainingFeedUnit$ArticleChainingFeedUnitExtra> {
        C02741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLArticleChainingFeedUnit$ArticleChainingFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLArticleChainingFeedUnit$ArticleChainingFeedUnitExtra[i];
        }
    }

    protected GraphQLArticleChainingFeedUnit$ArticleChainingFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
