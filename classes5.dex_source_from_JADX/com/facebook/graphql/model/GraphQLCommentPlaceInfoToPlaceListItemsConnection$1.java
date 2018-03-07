package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_ask_friends_enabled */
final class GraphQLCommentPlaceInfoToPlaceListItemsConnection$1 implements Creator<GraphQLCommentPlaceInfoToPlaceListItemsConnection> {
    GraphQLCommentPlaceInfoToPlaceListItemsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLCommentPlaceInfoToPlaceListItemsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLCommentPlaceInfoToPlaceListItemsConnection[i];
    }
}
