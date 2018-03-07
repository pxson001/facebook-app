package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: landing_page_redirect_instruction */
final class GraphQLAdditionalSuggestedPostAdItemsConnection$1 implements Creator<GraphQLAdditionalSuggestedPostAdItemsConnection> {
    GraphQLAdditionalSuggestedPostAdItemsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAdditionalSuggestedPostAdItemsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAdditionalSuggestedPostAdItemsConnection[i];
    }
}
