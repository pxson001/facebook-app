package com.facebook.api.ufiservices;

import com.facebook.graphql.executor.DefaultCacheProcessor;
import com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.model.GraphQLComment;
import com.google.common.collect.Sets;

/* compiled from: promoted_download */
public class FetchSingleCommentMethod$FetchCommentGQLCacheProcessor implements CacheProcessor<GraphQLComment> {
    final FetchSingleCommentParams f7164a;
    DefaultCacheProcessor<GraphQLComment> f7165b;
    final /* synthetic */ FetchSingleCommentMethod f7166c;

    public FetchSingleCommentMethod$FetchCommentGQLCacheProcessor(FetchSingleCommentMethod fetchSingleCommentMethod, FetchSingleCommentParams fetchSingleCommentParams, DefaultCacheProcessor<GraphQLComment> defaultCacheProcessor) {
        this.f7166c = fetchSingleCommentMethod;
        this.f7164a = fetchSingleCommentParams;
        this.f7165b = defaultCacheProcessor;
    }

    public final GraphQLResult<GraphQLComment> m10336a() {
        return this.f7165b.a();
    }

    public final GraphQLResult<GraphQLComment> m10337a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent) {
        return this.f7165b.a(graphQLQueryAnalyticsEvent);
    }

    public final boolean m10338a(GraphQLResult<GraphQLComment> graphQLResult) {
        this.f7165b.a(graphQLResult);
        return true;
    }

    public final GraphQLResult<GraphQLComment> m10339b(GraphQLResult<GraphQLComment> graphQLResult) {
        return Builder.a(graphQLResult).a(Sets.a(new String[]{this.f7164a.f7179b})).a();
    }
}
