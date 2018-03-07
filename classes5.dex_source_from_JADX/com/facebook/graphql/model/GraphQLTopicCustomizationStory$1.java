package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: UFIFeedbackQuery */
final class GraphQLTopicCustomizationStory$1 implements Creator<GraphQLTopicCustomizationStory> {
    GraphQLTopicCustomizationStory$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTopicCustomizationStory(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTopicCustomizationStory[i];
    }
}
