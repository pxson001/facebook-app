package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: headline_source */
public class GraphQLFindGroupsFeedUnit$FindGroupsFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLFindGroupsFeedUnit$FindGroupsFeedUnitExtra> CREATOR = new C03251();

    /* compiled from: headline_source */
    final class C03251 implements Creator<GraphQLFindGroupsFeedUnit$FindGroupsFeedUnitExtra> {
        C03251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFindGroupsFeedUnit$FindGroupsFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFindGroupsFeedUnit$FindGroupsFeedUnitExtra[i];
        }
    }

    protected GraphQLFindGroupsFeedUnit$FindGroupsFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
