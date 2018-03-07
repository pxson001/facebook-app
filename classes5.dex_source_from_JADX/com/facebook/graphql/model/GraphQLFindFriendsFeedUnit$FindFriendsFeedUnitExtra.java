package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: help_center_url */
public class GraphQLFindFriendsFeedUnit$FindFriendsFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLFindFriendsFeedUnit$FindFriendsFeedUnitExtra> CREATOR = new C03241();

    /* compiled from: help_center_url */
    final class C03241 implements Creator<GraphQLFindFriendsFeedUnit$FindFriendsFeedUnitExtra> {
        C03241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFindFriendsFeedUnit$FindFriendsFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFindFriendsFeedUnit$FindFriendsFeedUnitExtra[i];
        }
    }

    protected GraphQLFindFriendsFeedUnit$FindFriendsFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
