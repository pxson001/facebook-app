package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: install_messenger_learn_more_button */
final class GraphQLEventCategoryData$1 implements Creator<GraphQLEventCategoryData> {
    GraphQLEventCategoryData$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLEventCategoryData(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLEventCategoryData[i];
    }
}
