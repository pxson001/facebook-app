package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: groups_rhc_module */
final class GraphQLFundraiserCharity$1 implements Creator<GraphQLFundraiserCharity> {
    GraphQLFundraiserCharity$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFundraiserCharity(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFundraiserCharity[i];
    }
}
