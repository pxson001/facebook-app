package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: forceCodeForRefreshToken */
public class GraphQLHoldoutAdFeedUnit$HoldoutAdFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLHoldoutAdFeedUnit$HoldoutAdFeedUnitExtra> CREATOR = new C04121();

    /* compiled from: forceCodeForRefreshToken */
    final class C04121 implements Creator<GraphQLHoldoutAdFeedUnit$HoldoutAdFeedUnitExtra> {
        C04121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLHoldoutAdFeedUnit$HoldoutAdFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLHoldoutAdFeedUnit$HoldoutAdFeedUnitExtra[i];
        }
    }

    protected GraphQLHoldoutAdFeedUnit$HoldoutAdFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
