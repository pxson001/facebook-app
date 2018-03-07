package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: jewel_install_messenger_promo_fragment */
final class GraphQLAlbumsConnection$1 implements Creator<GraphQLAlbumsConnection> {
    GraphQLAlbumsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAlbumsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAlbumsConnection[i];
    }
}
