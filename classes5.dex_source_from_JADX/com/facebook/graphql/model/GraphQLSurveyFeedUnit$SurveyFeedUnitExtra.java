package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: UP */
public class GraphQLSurveyFeedUnit$SurveyFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLSurveyFeedUnit$SurveyFeedUnitExtra> CREATOR = new C12481();

    /* compiled from: UP */
    final class C12481 implements Creator<GraphQLSurveyFeedUnit$SurveyFeedUnitExtra> {
        C12481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSurveyFeedUnit$SurveyFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSurveyFeedUnit$SurveyFeedUnitExtra[i];
        }
    }

    protected GraphQLSurveyFeedUnit$SurveyFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
