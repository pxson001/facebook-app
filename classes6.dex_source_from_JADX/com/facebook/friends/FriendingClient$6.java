package com.facebook.friends;

import com.facebook.friends.protocol.FriendMutationsModels.FriendRequestSendCoreMutationFieldsModel;
import com.facebook.friends.protocol.FriendMutationsModels.FriendRequestSendCoreMutationFieldsModel.FriendRequesteesModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$6 implements Function<GraphQLResult<FriendRequestSendCoreMutationFieldsModel>, GraphQLFriendshipStatus> {
    final /* synthetic */ FriendingClient f10549a;

    FriendingClient$6(FriendingClient friendingClient) {
        this.f10549a = friendingClient;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        return (graphQLResult == null || ((FriendRequestSendCoreMutationFieldsModel) graphQLResult.e).m17263a().isEmpty()) ? null : ((FriendRequesteesModel) ((FriendRequestSendCoreMutationFieldsModel) graphQLResult.e).m17263a().get(0)).m17259j();
    }
}
