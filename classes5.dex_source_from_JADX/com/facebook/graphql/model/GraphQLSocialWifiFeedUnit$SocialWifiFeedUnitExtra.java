package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: UserEducationExperiencesEdge */
public class GraphQLSocialWifiFeedUnit$SocialWifiFeedUnitExtra extends FeedUnitExtra {
    public static final Creator<GraphQLSocialWifiFeedUnit$SocialWifiFeedUnitExtra> CREATOR = new C12261();

    /* compiled from: UserEducationExperiencesEdge */
    final class C12261 implements Creator<GraphQLSocialWifiFeedUnit$SocialWifiFeedUnitExtra> {
        C12261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSocialWifiFeedUnit$SocialWifiFeedUnitExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSocialWifiFeedUnit$SocialWifiFeedUnitExtra[i];
        }
    }

    protected GraphQLSocialWifiFeedUnit$SocialWifiFeedUnitExtra(Parcel parcel) {
        super(parcel);
    }
}
