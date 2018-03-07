package com.facebook.friends;

import com.facebook.friends.model.FetchFriendRequestResult;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLModels.FriendRequestQueryModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/picture/%s */
class FriendingQueryExecutor$1 implements Function<GraphQLResult<FriendRequestQueryModel>, FetchFriendRequestResult> {
    final /* synthetic */ FriendingQueryExecutor f10555a;

    FriendingQueryExecutor$1(FriendingQueryExecutor friendingQueryExecutor) {
        this.f10555a = friendingQueryExecutor;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            return null;
        }
        return new FetchFriendRequestResult(FriendingQueryExecutor.a(((FriendRequestQueryModel) graphQLResult.e).m16943a().m16939a()), FriendingQueryExecutor.a(((FriendRequestQueryModel) graphQLResult.e).m16943a().m16940j()));
    }
}
