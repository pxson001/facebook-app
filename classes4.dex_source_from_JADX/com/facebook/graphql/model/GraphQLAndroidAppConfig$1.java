package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: original_locale */
final class GraphQLAndroidAppConfig$1 implements Creator<GraphQLAndroidAppConfig> {
    GraphQLAndroidAppConfig$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAndroidAppConfig(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAndroidAppConfig[i];
    }
}
