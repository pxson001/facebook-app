package com.facebook.friends;

import com.facebook.friends.protocol.FriendMutationsModels.FriendRequestAcceptCoreMutationFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$1 implements Function<GraphQLResult<FriendRequestAcceptCoreMutationFieldsModel>, GraphQLFriendshipStatus> {
    final /* synthetic */ FriendingClient f10544a;

    FriendingClient$1(FriendingClient friendingClient) {
        this.f10544a = friendingClient;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        return (graphQLResult == null || ((FriendRequestAcceptCoreMutationFieldsModel) graphQLResult.e).m17187a() == null) ? null : ((FriendRequestAcceptCoreMutationFieldsModel) graphQLResult.e).m17187a().m17184j();
    }
}
