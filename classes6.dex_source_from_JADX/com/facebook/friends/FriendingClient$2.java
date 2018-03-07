package com.facebook.friends;

import com.facebook.friends.protocol.FriendMutationsModels.FriendRequestDeleteCoreMutationFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$2 implements Function<GraphQLResult<FriendRequestDeleteCoreMutationFieldsModel>, GraphQLFriendshipStatus> {
    final /* synthetic */ FriendingClient f10545a;

    FriendingClient$2(FriendingClient friendingClient) {
        this.f10545a = friendingClient;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        return (graphQLResult == null || ((FriendRequestDeleteCoreMutationFieldsModel) graphQLResult.e).m17237a() == null) ? null : ((FriendRequestDeleteCoreMutationFieldsModel) graphQLResult.e).m17237a().m17234j();
    }
}
