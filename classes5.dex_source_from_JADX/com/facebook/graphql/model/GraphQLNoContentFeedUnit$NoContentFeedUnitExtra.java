package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: event_tips */
public class GraphQLNoContentFeedUnit$NoContentFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLNoContentFeedUnit$NoContentFeedUnitExtra> CREATOR = new C04471();

    /* compiled from: event_tips */
    final class C04471 implements Creator<GraphQLNoContentFeedUnit$NoContentFeedUnitExtra> {
        C04471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNoContentFeedUnit$NoContentFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNoContentFeedUnit$NoContentFeedUnitExtra[i];
        }
    }

    protected GraphQLNoContentFeedUnit$NoContentFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
