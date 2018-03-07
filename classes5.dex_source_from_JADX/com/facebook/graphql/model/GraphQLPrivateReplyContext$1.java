package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Value returned by 'any-getter' ( */
final class GraphQLPrivateReplyContext$1 implements Creator<GraphQLPrivateReplyContext> {
    GraphQLPrivateReplyContext$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPrivateReplyContext(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPrivateReplyContext[i];
    }
}
