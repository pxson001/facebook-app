package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: user/ */
final class GraphQLTaggableActivityPreviewTemplate$1 implements Creator<GraphQLTaggableActivityPreviewTemplate> {
    GraphQLTaggableActivityPreviewTemplate$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLTaggableActivityPreviewTemplate(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLTaggableActivityPreviewTemplate[i];
    }
}
