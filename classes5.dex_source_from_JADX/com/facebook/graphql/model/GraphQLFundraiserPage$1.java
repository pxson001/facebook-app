package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: group_story_chattable_members */
final class GraphQLFundraiserPage$1 implements Creator<GraphQLFundraiserPage> {
    GraphQLFundraiserPage$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFundraiserPage(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFundraiserPage[i];
    }
}
