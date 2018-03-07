package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: TimeRange */
public class GraphQLVideoChainingFeedUnit$VideoChainingFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLVideoChainingFeedUnit$VideoChainingFeedUnitExtra> CREATOR = new C12701();

    /* compiled from: TimeRange */
    final class C12701 implements Creator<GraphQLVideoChainingFeedUnit$VideoChainingFeedUnitExtra> {
        C12701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLVideoChainingFeedUnit$VideoChainingFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLVideoChainingFeedUnit$VideoChainingFeedUnitExtra[i];
        }
    }

    protected GraphQLVideoChainingFeedUnit$VideoChainingFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
