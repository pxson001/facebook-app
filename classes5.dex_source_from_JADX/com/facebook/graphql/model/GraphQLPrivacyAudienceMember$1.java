package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ViewUtils */
final class GraphQLPrivacyAudienceMember$1 implements Creator<GraphQLPrivacyAudienceMember> {
    GraphQLPrivacyAudienceMember$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPrivacyAudienceMember(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPrivacyAudienceMember[i];
    }
}
