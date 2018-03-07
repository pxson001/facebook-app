package com.facebook.friends;

import com.facebook.friends.protocol.FriendMutationsModels.FriendRemoveCoreMutationFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$10 implements Function<GraphQLResult<FriendRemoveCoreMutationFieldsModel>, GraphQLFriendshipStatus> {
    final /* synthetic */ FriendingClient f10537a;

    FriendingClient$10(FriendingClient friendingClient) {
        this.f10537a = friendingClient;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        return (graphQLResult == null || ((FriendRemoveCoreMutationFieldsModel) graphQLResult.e).m17162a() == null) ? null : ((FriendRemoveCoreMutationFieldsModel) graphQLResult.e).m17162a().m17160j();
    }
}
