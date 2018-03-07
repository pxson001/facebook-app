package com.facebook.friending.center.fetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQL;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQL.FriendsCenterFetchSuggestionsQueryString;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQLModels.FriendsCenterFetchSuggestionsQueryModel;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: albums/<uid> */
public class FriendsCenterSuggestionsFetcher {
    @VisibleForTesting
    DefaultPageInfoFieldsModel f19982a = m20150c();
    private final GraphQLQueryExecutor f19983b;
    private final ListeningExecutorService f19984c;

    /* compiled from: albums/<uid> */
    class C28111 implements Function<GraphQLResult<FriendsCenterFetchSuggestionsQueryModel>, ImmutableList<FriendsCenterDefaultNodeModel>> {
        final /* synthetic */ FriendsCenterSuggestionsFetcher f19981a;

        C28111(FriendsCenterSuggestionsFetcher friendsCenterSuggestionsFetcher) {
            this.f19981a = friendsCenterSuggestionsFetcher;
        }

        @Nonnull
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FriendsCenterFetchSuggestionsQueryModel) graphQLResult.e).m20300a() == null || ((FriendsCenterFetchSuggestionsQueryModel) graphQLResult.e).m20300a().m20297j() == null) {
                return RegularImmutableList.a;
            }
            this.f19981a.f19982a = ((FriendsCenterFetchSuggestionsQueryModel) graphQLResult.e).m20300a().m20297j();
            return ((FriendsCenterFetchSuggestionsQueryModel) graphQLResult.e).m20300a().m20296a();
        }
    }

    public static FriendsCenterSuggestionsFetcher m20149b(InjectorLike injectorLike) {
        return new FriendsCenterSuggestionsFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsCenterSuggestionsFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f19983b = graphQLQueryExecutor;
        this.f19984c = listeningExecutorService;
    }

    public final ListenableFuture<ImmutableList<FriendsCenterDefaultNodeModel>> m20151a(CallerContext callerContext, int i, PeopleYouMayKnowLocation peopleYouMayKnowLocation) {
        Preconditions.checkNotNull(callerContext, "You must provide a caller context");
        FriendsCenterFetchSuggestionsQueryString a = FriendsCenterFetchSuggestionsGraphQL.m20290a();
        a.a("location", peopleYouMayKnowLocation.value).a("max", "250").a("after", this.f19982a.a()).a("first", String.valueOf(i));
        GraphQLRequest a2 = GraphQLRequest.a(a);
        GraphQLRequest a3 = a2.a(GraphQLCachePolicy.a).a(600);
        a3.e = ImmutableSet.of("FC_SUGGESTIONS_QUERY");
        a3 = a3;
        a3.f = callerContext;
        a3.b = true;
        return Futures.a(this.f19983b.a(a2), new C28111(this), this.f19984c);
    }

    public final boolean m20152a() {
        return this.f19982a.b();
    }

    public final void m20153b() {
        this.f19982a = m20150c();
    }

    private static DefaultPageInfoFieldsModel m20150c() {
        Builder builder = new Builder();
        builder.b = true;
        return builder.a();
    }
}
