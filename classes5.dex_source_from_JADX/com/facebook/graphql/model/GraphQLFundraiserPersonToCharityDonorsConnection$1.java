package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: group_owner_authored_stories */
final class GraphQLFundraiserPersonToCharityDonorsConnection$1 implements Creator<GraphQLFundraiserPersonToCharityDonorsConnection> {
    GraphQLFundraiserPersonToCharityDonorsConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFundraiserPersonToCharityDonorsConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFundraiserPersonToCharityDonorsConnection[i];
    }
}
