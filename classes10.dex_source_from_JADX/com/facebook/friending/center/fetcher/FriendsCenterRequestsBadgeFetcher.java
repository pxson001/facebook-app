package com.facebook.friending.center.fetcher;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.friends.protocol.FetchFriendRequestJewelCountGraphQLModels.FetchFriendRequestJewelCountGraphQLModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: alertID */
public class FriendsCenterRequestsBadgeFetcher {
    public final GraphQLQueryExecutor f19971a;
    public final ListeningExecutorService f19972b;

    /* compiled from: alertID */
    public class C28081 implements Function<GraphQLResult<FetchFriendRequestJewelCountGraphQLModel>, Integer> {
        final /* synthetic */ FriendsCenterRequestsBadgeFetcher f19970a;

        public C28081(FriendsCenterRequestsBadgeFetcher friendsCenterRequestsBadgeFetcher) {
            this.f19970a = friendsCenterRequestsBadgeFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchFriendRequestJewelCountGraphQLModel) graphQLResult.e).a() == null) {
                return Integer.valueOf(0);
            }
            return Integer.valueOf(((FetchFriendRequestJewelCountGraphQLModel) graphQLResult.e).a().a());
        }
    }

    public static FriendsCenterRequestsBadgeFetcher m20142b(InjectorLike injectorLike) {
        return new FriendsCenterRequestsBadgeFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsCenterRequestsBadgeFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f19971a = graphQLQueryExecutor;
        this.f19972b = listeningExecutorService;
    }
}
