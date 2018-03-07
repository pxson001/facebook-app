package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: UFIFeedbackQuery */
public class GraphQLTopicCustomizationStory$TopicCustomizationStoryExtra extends FeedUnitExtra {
    public static final Creator<GraphQLTopicCustomizationStory$TopicCustomizationStoryExtra> CREATOR = new C12581();

    /* compiled from: UFIFeedbackQuery */
    final class C12581 implements Creator<GraphQLTopicCustomizationStory$TopicCustomizationStoryExtra> {
        C12581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTopicCustomizationStory$TopicCustomizationStoryExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTopicCustomizationStory$TopicCustomizationStoryExtra[i];
        }
    }

    protected GraphQLTopicCustomizationStory$TopicCustomizationStoryExtra(Parcel parcel) {
        super(parcel);
    }
}
