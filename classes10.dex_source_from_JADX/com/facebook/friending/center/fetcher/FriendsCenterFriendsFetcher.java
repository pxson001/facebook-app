package com.facebook.friending.center.fetcher;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQLModels.FriendsCenterFetchFriendsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: allDay */
public class FriendsCenterFriendsFetcher {
    public static final List<String> f19965b = Lists.a(new String[]{"first_name"});
    @VisibleForTesting
    public DefaultPageInfoFieldsModel f19966a = m20140d();
    public final GraphQLQueryExecutor f19967c;
    public final ListeningExecutorService f19968d;
    public Boolean f19969e;

    /* compiled from: allDay */
    public class C28071 implements Function<GraphQLResult<FriendsCenterFetchFriendsQueryModel>, ImmutableList<FriendsCenterDefaultNodeModel>> {
        final /* synthetic */ FriendsCenterFriendsFetcher f19964a;

        public C28071(FriendsCenterFriendsFetcher friendsCenterFriendsFetcher) {
            this.f19964a = friendsCenterFriendsFetcher;
        }

        @Nonnull
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FriendsCenterFetchFriendsQueryModel) graphQLResult.e).m20224a() == null || ((FriendsCenterFetchFriendsQueryModel) graphQLResult.e).m20224a().m20220j() == null) {
                return RegularImmutableList.a;
            }
            if (this.f19964a.f19969e == null) {
                boolean z;
                FriendsCenterFriendsFetcher friendsCenterFriendsFetcher = this.f19964a;
                if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER) {
                    z = true;
                } else {
                    z = false;
                }
                friendsCenterFriendsFetcher.f19969e = Boolean.valueOf(z);
            }
            this.f19964a.f19966a = ((FriendsCenterFetchFriendsQueryModel) graphQLResult.e).m20224a().m20220j();
            return ((FriendsCenterFetchFriendsQueryModel) graphQLResult.e).m20224a().m20219a();
        }
    }

    public static FriendsCenterFriendsFetcher m20139b(InjectorLike injectorLike) {
        return new FriendsCenterFriendsFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsCenterFriendsFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f19967c = graphQLQueryExecutor;
        this.f19968d = listeningExecutorService;
    }

    public final boolean m20141a() {
        return this.f19966a.b();
    }

    public static DefaultPageInfoFieldsModel m20140d() {
        Builder builder = new Builder();
        builder.b = true;
        return builder.a();
    }
}
