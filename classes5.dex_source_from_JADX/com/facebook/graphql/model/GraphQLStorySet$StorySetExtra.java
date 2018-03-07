package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: UTF-8 */
public class GraphQLStorySet$StorySetExtra extends FeedUnitExtra {
    public static final Creator<GraphQLStorySet$StorySetExtra> CREATOR = new C12401();

    /* compiled from: UTF-8 */
    final class C12401 implements Creator<GraphQLStorySet$StorySetExtra> {
        C12401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStorySet$StorySetExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStorySet$StorySetExtra[i];
        }
    }

    protected GraphQLStorySet$StorySetExtra(Parcel parcel) {
        super(parcel);
    }
}
