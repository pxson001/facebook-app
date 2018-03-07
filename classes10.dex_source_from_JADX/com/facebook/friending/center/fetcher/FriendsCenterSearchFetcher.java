package com.facebook.friending.center.fetcher;

import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterSearchFriendsGraphQLModels.FriendsCenterSearchFriendsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: albums_edit_flow */
public class FriendsCenterSearchFetcher {
    @VisibleForTesting
    public DefaultPageInfoFieldsModel f19978a = m20147c();
    public final GraphQLQueryExecutor f19979b;
    public final ListeningExecutorService f19980c;

    /* compiled from: albums_edit_flow */
    public class C28101 implements Function<GraphQLResult<FriendsCenterSearchFriendsQueryModel>, ImmutableList<FriendsCenterDefaultNodeModel>> {
        final /* synthetic */ FriendsCenterSearchFetcher f19977a;

        public C28101(FriendsCenterSearchFetcher friendsCenterSearchFetcher) {
            this.f19977a = friendsCenterSearchFetcher;
        }

        @Nonnull
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FriendsCenterSearchFriendsQueryModel) graphQLResult.e).m20315a() == null || ((FriendsCenterSearchFriendsQueryModel) graphQLResult.e).m20315a().m20312j() == null) {
                return RegularImmutableList.a;
            }
            this.f19977a.f19978a = ((FriendsCenterSearchFriendsQueryModel) graphQLResult.e).m20315a().m20312j();
            return ((FriendsCenterSearchFriendsQueryModel) graphQLResult.e).m20315a().m20311a();
        }
    }

    @Inject
    public FriendsCenterSearchFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f19979b = graphQLQueryExecutor;
        this.f19980c = listeningExecutorService;
    }

    public final boolean m20148a() {
        return this.f19978a.b();
    }

    public static DefaultPageInfoFieldsModel m20147c() {
        Builder builder = new Builder();
        builder.b = true;
        return builder.a();
    }
}
