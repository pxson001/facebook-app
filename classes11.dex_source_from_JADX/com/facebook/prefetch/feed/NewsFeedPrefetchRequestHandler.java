package com.facebook.prefetch.feed;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feedtype.FeedType;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TC;>; */
public class NewsFeedPrefetchRequestHandler {
    static final FeedType f10821a = FeedType.b;
    private static final Class<?> f10822b = NewsFeedPrefetchRequestHandler.class;
    private final GraphQLQueryExecutor f10823c;
    private final FetchNewsFeedMethod f10824d;
    private final Provider<Boolean> f10825e;

    public static NewsFeedPrefetchRequestHandler m11298a(InjectorLike injectorLike) {
        return new NewsFeedPrefetchRequestHandler(GraphQLQueryExecutor.a(injectorLike), FetchNewsFeedMethod.b(injectorLike), IdBasedProvider.a(injectorLike, 3981));
    }

    @Inject
    public NewsFeedPrefetchRequestHandler(GraphQLQueryExecutor graphQLQueryExecutor, FetchNewsFeedMethod fetchNewsFeedMethod, Provider<Boolean> provider) {
        this.f10823c = graphQLQueryExecutor;
        this.f10824d = fetchNewsFeedMethod;
        this.f10825e = provider;
    }

    public final void m11299a(FetchFeedParams fetchFeedParams, String str, RequestObserver<GraphQLResult<GraphQLViewer>> requestObserver) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(str);
        graphQLBatchRequest.g = ((Boolean) this.f10825e.get()).booleanValue();
        int i = fetchFeedParams.c;
        FetchFeedParamsBuilder a = new FetchFeedParamsBuilder().a(fetchFeedParams);
        a.c = 1;
        TypedGraphQlQueryString e = this.f10824d.e(a.q());
        GraphQlQueryParamSet graphQlQueryParamSet = e.a;
        graphQlQueryParamSet.b("param", "after_home_story_param");
        graphQlQueryParamSet.b("import", "end_cursor");
        graphQlQueryParamSet.b("max_runs", Integer.valueOf(i > 0 ? i - 1 : 0));
        e.a("storyset_first_fetch_size", Integer.valueOf(5));
        e.a("pyml_first_fetch_size", Integer.valueOf(5));
        GraphQLRequest a2 = GraphQLRequest.a(e).a(graphQlQueryParamSet).a(GraphQLCachePolicy.c);
        a2.b = true;
        graphQLBatchRequest.a(a2).a(requestObserver);
        this.f10823c.a(graphQLBatchRequest);
    }
}
