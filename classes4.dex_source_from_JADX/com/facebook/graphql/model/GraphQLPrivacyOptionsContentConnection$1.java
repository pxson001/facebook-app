package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: presence_map_reset_on_topic_unsubscribe */
final class GraphQLPrivacyOptionsContentConnection$1 implements Creator<GraphQLPrivacyOptionsContentConnection> {
    GraphQLPrivacyOptionsContentConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPrivacyOptionsContentConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPrivacyOptionsContentConnection[i];
    }
}
