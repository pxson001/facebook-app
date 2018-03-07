package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: has_comprehensive_title */
public class GraphQLFriendsLocationsFeedUnit$FriendsLocationsFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLFriendsLocationsFeedUnit$FriendsLocationsFeedUnitExtra> CREATOR = new C03331();

    /* compiled from: has_comprehensive_title */
    final class C03331 implements Creator<GraphQLFriendsLocationsFeedUnit$FriendsLocationsFeedUnitExtra> {
        C03331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendsLocationsFeedUnit$FriendsLocationsFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendsLocationsFeedUnit$FriendsLocationsFeedUnitExtra[i];
        }
    }

    protected GraphQLFriendsLocationsFeedUnit$FriendsLocationsFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
