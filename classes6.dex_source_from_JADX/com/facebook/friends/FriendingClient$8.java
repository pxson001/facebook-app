package com.facebook.friends;

import com.facebook.friends.protocol.FriendMutationsModels.FriendRequestCancelCoreMutationFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$8 implements Function<GraphQLResult<FriendRequestCancelCoreMutationFieldsModel>, GraphQLFriendshipStatus> {
    final /* synthetic */ FriendingClient f10553a;

    FriendingClient$8(FriendingClient friendingClient) {
        this.f10553a = friendingClient;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        return (graphQLResult == null || ((FriendRequestCancelCoreMutationFieldsModel) graphQLResult.e).m17212a() == null) ? null : ((FriendRequestCancelCoreMutationFieldsModel) graphQLResult.e).m17212a().m17208j();
    }
}
