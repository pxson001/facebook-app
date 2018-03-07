package com.facebook.friending.center.fetcher;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLModels.FriendCenterRequestEdgeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLModels.FriendsCenterFetchRequestsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: albums_to_fetch */
public class FriendsCenterRequestsFetcher {
    @VisibleForTesting
    public DefaultPageInfoFieldsModel f19974a = m20144c();
    public final GraphQLQueryExecutor f19975b;
    public final ListeningExecutorService f19976c;

    /* compiled from: albums_to_fetch */
    public class C28091 implements Function<GraphQLResult<FriendsCenterFetchRequestsQueryModel>, ImmutableList<FriendCenterRequestEdgeModel>> {
        final /* synthetic */ FriendsCenterRequestsFetcher f19973a;

        public C28091(FriendsCenterRequestsFetcher friendsCenterRequestsFetcher) {
            this.f19973a = friendsCenterRequestsFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FriendsCenterFetchRequestsQueryModel) graphQLResult.e).m20256a() == null || ((FriendsCenterFetchRequestsQueryModel) graphQLResult.e).m20256a().m20253j() == null) {
                return RegularImmutableList.a;
            }
            this.f19973a.f19974a = ((FriendsCenterFetchRequestsQueryModel) graphQLResult.e).m20256a().m20253j();
            return ((FriendsCenterFetchRequestsQueryModel) graphQLResult.e).m20256a().m20252a();
        }
    }

    public static FriendsCenterRequestsFetcher m20143b(InjectorLike injectorLike) {
        return new FriendsCenterRequestsFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsCenterRequestsFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f19975b = graphQLQueryExecutor;
        this.f19976c = listeningExecutorService;
    }

    public final boolean m20145a() {
        return this.f19974a.b();
    }

    public final void m20146b() {
        this.f19974a = m20144c();
    }

    private static DefaultPageInfoFieldsModel m20144c() {
        Builder builder = new Builder();
        builder.b = true;
        return builder.a();
    }
}
