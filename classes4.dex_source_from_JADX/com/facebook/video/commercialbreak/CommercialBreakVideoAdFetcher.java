package com.facebook.video.commercialbreak;

import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.video.commercialbreak.protocol.FetchInstreamVideoAds.InstreamVideoAdsQueryString;
import javax.inject.Inject;

/* compiled from: platform_webdialogs/ */
public class CommercialBreakVideoAdFetcher {
    private final FetchFeedQueryUtil f4529a;
    private final GraphQLQueryExecutor f4530b;

    @Inject
    public CommercialBreakVideoAdFetcher(FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f4529a = fetchFeedQueryUtil;
        this.f4530b = graphQLQueryExecutor;
    }

    public final GraphQLQueryFuture<GraphQLResult> m5039a(String str, int i) {
        GraphQlQueryString instreamVideoAdsQueryString = new InstreamVideoAdsQueryString();
        instreamVideoAdsQueryString.a("host_video_id", str).a("duration", Integer.valueOf(i));
        this.f4529a.a(instreamVideoAdsQueryString);
        this.f4529a.b(instreamVideoAdsQueryString);
        GraphQLRequest a = GraphQLRequest.a(instreamVideoAdsQueryString).a(GraphQLCachePolicy.c);
        a.b = true;
        return this.f4530b.a(a);
    }
}
