package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: guest_status */
final class GraphQLFundraiserCampaign$1 implements Creator<GraphQLFundraiserCampaign> {
    GraphQLFundraiserCampaign$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLFundraiserCampaign(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLFundraiserCampaign[i];
    }
}
