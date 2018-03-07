package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: small_audience_privacy_nux_config */
final class GraphQLPrivacyRowInput$1 implements Creator<GraphQLPrivacyRowInput> {
    GraphQLPrivacyRowInput$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPrivacyRowInput(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPrivacyRowInput[i];
    }
}
