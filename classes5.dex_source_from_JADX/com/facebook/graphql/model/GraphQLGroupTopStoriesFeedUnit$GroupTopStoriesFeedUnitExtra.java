package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: friendEventMembers */
public class GraphQLGroupTopStoriesFeedUnit$GroupTopStoriesFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLGroupTopStoriesFeedUnit$GroupTopStoriesFeedUnitExtra> CREATOR = new C04011();

    /* compiled from: friendEventMembers */
    final class C04011 implements Creator<GraphQLGroupTopStoriesFeedUnit$GroupTopStoriesFeedUnitExtra> {
        C04011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupTopStoriesFeedUnit$GroupTopStoriesFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupTopStoriesFeedUnit$GroupTopStoriesFeedUnitExtra[i];
        }
    }

    protected GraphQLGroupTopStoriesFeedUnit$GroupTopStoriesFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
