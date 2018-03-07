package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: WORKPLACE_OFFICE */
public class GraphQLPeopleYouMayKnowFeedUnit$PeopleYouMayKnowFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLPeopleYouMayKnowFeedUnit$PeopleYouMayKnowFeedUnitExtra> CREATOR = new C11661();

    /* compiled from: WORKPLACE_OFFICE */
    final class C11661 implements Creator<GraphQLPeopleYouMayKnowFeedUnit$PeopleYouMayKnowFeedUnitExtra> {
        C11661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPeopleYouMayKnowFeedUnit$PeopleYouMayKnowFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPeopleYouMayKnowFeedUnit$PeopleYouMayKnowFeedUnitExtra[i];
        }
    }

    protected GraphQLPeopleYouMayKnowFeedUnit$PeopleYouMayKnowFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
