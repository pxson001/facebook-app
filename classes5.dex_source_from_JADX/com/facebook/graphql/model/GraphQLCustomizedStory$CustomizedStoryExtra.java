package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: ios_post_checkin_upload_photo */
public class GraphQLCustomizedStory$CustomizedStoryExtra extends FeedUnitExtra {
    public static final Creator<GraphQLCustomizedStory$CustomizedStoryExtra> CREATOR = new C02931();

    /* compiled from: ios_post_checkin_upload_photo */
    final class C02931 implements Creator<GraphQLCustomizedStory$CustomizedStoryExtra> {
        C02931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCustomizedStory$CustomizedStoryExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCustomizedStory$CustomizedStoryExtra[i];
        }
    }

    protected GraphQLCustomizedStory$CustomizedStoryExtra(Parcel parcel) {
        super(parcel);
    }
}
