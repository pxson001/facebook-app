package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: is_viewer_newly_added */
final class GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection$1 implements Creator<GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection> {
    GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection(parcel);
    }

    public final Object[] newArray(int i) {
        return new GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection[i];
    }
}
