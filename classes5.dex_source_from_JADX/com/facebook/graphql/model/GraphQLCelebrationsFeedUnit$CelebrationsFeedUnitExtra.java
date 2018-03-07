package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: is_editable */
public class GraphQLCelebrationsFeedUnit$CelebrationsFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLCelebrationsFeedUnit$CelebrationsFeedUnitExtra> CREATOR = new C02811();

    /* compiled from: is_editable */
    final class C02811 implements Creator<GraphQLCelebrationsFeedUnit$CelebrationsFeedUnitExtra> {
        C02811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCelebrationsFeedUnit$CelebrationsFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCelebrationsFeedUnit$CelebrationsFeedUnitExtra[i];
        }
    }

    protected GraphQLCelebrationsFeedUnit$CelebrationsFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
