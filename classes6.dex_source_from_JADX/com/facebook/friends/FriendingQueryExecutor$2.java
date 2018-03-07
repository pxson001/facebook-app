package com.facebook.friends;

import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PeopleYouMayKnowQueryModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/picture/%s */
class FriendingQueryExecutor$2 implements Function<GraphQLResult<PeopleYouMayKnowQueryModel>, FetchPeopleYouMayKnowResult> {
    final /* synthetic */ FriendingQueryExecutor f10556a;

    FriendingQueryExecutor$2(FriendingQueryExecutor friendingQueryExecutor) {
        this.f10556a = friendingQueryExecutor;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            return null;
        }
        return new FetchPeopleYouMayKnowResult(FriendingQueryExecutor.b(((PeopleYouMayKnowQueryModel) graphQLResult.e).m17017a().m17013a()), FriendingQueryExecutor.a(((PeopleYouMayKnowQueryModel) graphQLResult.e).m17017a().m17014j()));
    }
}
