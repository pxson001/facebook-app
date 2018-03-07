package com.facebook.groups.feed.protocol;

import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: react_native */
public class FetchFeedbackForStoriesMethod {
    public final FetchFeedbackMethod f5514a;

    /* compiled from: react_native */
    public class C05261 implements CacheProcessor<GraphQLStory> {
        final /* synthetic */ CacheProcessor f5512a;
        final /* synthetic */ FetchFeedbackForStoriesMethod f5513b;

        public C05261(FetchFeedbackForStoriesMethod fetchFeedbackForStoriesMethod, CacheProcessor cacheProcessor) {
            this.f5513b = fetchFeedbackForStoriesMethod;
            this.f5512a = cacheProcessor;
        }

        public final GraphQLResult<GraphQLStory> m6243a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent) {
            return null;
        }

        public final GraphQLResult<GraphQLStory> m6242a() {
            return null;
        }

        public final boolean m6244a(GraphQLResult<GraphQLStory> graphQLResult) {
            return this.f5512a.a(FetchFeedbackForStoriesMethod.m6246b((GraphQLResult) graphQLResult));
        }

        public final GraphQLResult<GraphQLStory> m6245b(GraphQLResult<GraphQLStory> graphQLResult) {
            this.f5512a.b(FetchFeedbackForStoriesMethod.m6246b((GraphQLResult) graphQLResult));
            return graphQLResult;
        }
    }

    public static FetchFeedbackForStoriesMethod m6247b(InjectorLike injectorLike) {
        return new FetchFeedbackForStoriesMethod(FetchFeedbackMethod.b(injectorLike));
    }

    @Inject
    public FetchFeedbackForStoriesMethod(FetchFeedbackMethod fetchFeedbackMethod) {
        this.f5514a = fetchFeedbackMethod;
    }

    public static GraphQLResult<GraphQLFeedback> m6246b(GraphQLResult<GraphQLStory> graphQLResult) {
        Builder builder = ImmutableList.builder();
        for (GraphQLStory l : graphQLResult.e()) {
            builder.c(l.l());
        }
        return new GraphQLResult(builder.b(), graphQLResult.freshness, graphQLResult.clientTimeMs);
    }
}
