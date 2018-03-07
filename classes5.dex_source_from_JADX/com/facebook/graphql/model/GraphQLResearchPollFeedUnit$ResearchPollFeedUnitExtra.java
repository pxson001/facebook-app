package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: VIDEO_HOME_PINNED_TOPICS_LIVE */
public class GraphQLResearchPollFeedUnit$ResearchPollFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLResearchPollFeedUnit$ResearchPollFeedUnitExtra> CREATOR = new C12061();

    /* compiled from: VIDEO_HOME_PINNED_TOPICS_LIVE */
    final class C12061 implements Creator<GraphQLResearchPollFeedUnit$ResearchPollFeedUnitExtra> {
        C12061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollFeedUnit$ResearchPollFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollFeedUnit$ResearchPollFeedUnitExtra[i];
        }
    }

    protected GraphQLResearchPollFeedUnit$ResearchPollFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
