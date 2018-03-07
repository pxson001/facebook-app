package com.facebook.friends;

import com.facebook.friends.protocol.FriendMutationsModels.FriendSuggestionIgnoreCoreMutationFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$9 implements Function<GraphQLResult<FriendSuggestionIgnoreCoreMutationFieldsModel>, GraphQLFriendshipStatus> {
    final /* synthetic */ FriendingClient f10554a;

    FriendingClient$9(FriendingClient friendingClient) {
        this.f10554a = friendingClient;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        return (graphQLResult == null || ((FriendSuggestionIgnoreCoreMutationFieldsModel) graphQLResult.e).m17287a() == null) ? null : ((FriendSuggestionIgnoreCoreMutationFieldsModel) graphQLResult.e).m17287a().m17284j();
    }
}
