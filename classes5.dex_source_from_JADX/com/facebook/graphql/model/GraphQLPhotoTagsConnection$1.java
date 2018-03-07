package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WILDE_GROUPS_TAB_MENU */
final class GraphQLPhotoTagsConnection$1 implements Creator<GraphQLPhotoTagsConnection> {
    GraphQLPhotoTagsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLPhotoTagsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLPhotoTagsConnection[i];
    }
}
