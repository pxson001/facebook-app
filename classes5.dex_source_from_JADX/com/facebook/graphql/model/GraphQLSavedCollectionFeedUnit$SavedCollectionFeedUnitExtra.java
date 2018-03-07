package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: VETERINARIAN */
public class GraphQLSavedCollectionFeedUnit$SavedCollectionFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLSavedCollectionFeedUnit$SavedCollectionFeedUnitExtra> CREATOR = new C12161();

    /* compiled from: VETERINARIAN */
    final class C12161 implements Creator<GraphQLSavedCollectionFeedUnit$SavedCollectionFeedUnitExtra> {
        C12161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSavedCollectionFeedUnit$SavedCollectionFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSavedCollectionFeedUnit$SavedCollectionFeedUnitExtra[i];
        }
    }

    protected GraphQLSavedCollectionFeedUnit$SavedCollectionFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
