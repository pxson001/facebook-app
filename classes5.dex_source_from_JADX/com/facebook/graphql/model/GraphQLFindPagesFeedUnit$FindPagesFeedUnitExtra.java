package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: header_image */
public class GraphQLFindPagesFeedUnit$FindPagesFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLFindPagesFeedUnit$FindPagesFeedUnitExtra> CREATOR = new C03261();

    /* compiled from: header_image */
    final class C03261 implements Creator<GraphQLFindPagesFeedUnit$FindPagesFeedUnitExtra> {
        C03261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFindPagesFeedUnit$FindPagesFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFindPagesFeedUnit$FindPagesFeedUnitExtra[i];
        }
    }

    protected GraphQLFindPagesFeedUnit$FindPagesFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
