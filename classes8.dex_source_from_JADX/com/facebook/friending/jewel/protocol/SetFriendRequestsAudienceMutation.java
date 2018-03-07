package com.facebook.friending.jewel.protocol;

import com.facebook.friending.jewel.protocol.SetFriendRequestsAudienceMutationModels.SetFriendRequestsAudienceMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: filter_cleared */
public final class SetFriendRequestsAudienceMutation {

    /* compiled from: filter_cleared */
    public class SetFriendRequestsAudienceMutationString extends TypedGraphQLMutationString<SetFriendRequestsAudienceMutationModel> {
        public SetFriendRequestsAudienceMutationString() {
            super(SetFriendRequestsAudienceMutationModel.class, false, "SetFriendRequestsAudienceMutation", "d0ba6ef374de09965156ef7fe403c75a", "set_friend_requests_audience", "0", "10154204803306729", RegularImmutableSet.a);
        }

        public final String m14980a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
