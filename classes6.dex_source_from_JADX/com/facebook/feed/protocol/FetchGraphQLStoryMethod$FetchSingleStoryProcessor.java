package com.facebook.feed.protocol;

import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.story.FetchSingleStoryResult;
import com.facebook.api.ufiservices.common.FeedbackCacheProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.DefaultCacheProcessor;
import com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.data.DefaultFeedbackCacheProvider;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: moduleName */
public class FetchGraphQLStoryMethod$FetchSingleStoryProcessor implements CacheProcessor<GraphQLStory> {
    final FetchSingleStoryParams f10220a;
    DefaultCacheProcessor<GraphQLStory> f10221b;
    final String f10222c;
    public final DefaultFeedbackCacheProvider f10223d;
    public List<GraphQLFeedback> f10224e = new ArrayList();
    final /* synthetic */ FetchGraphQLStoryMethod f10225f;

    public final boolean m16011a(GraphQLResult<GraphQLStory> graphQLResult) {
        if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER) {
            this.f10225f.p.a(((GraphQLStory) graphQLResult.e).l());
        }
        this.f10221b.a(graphQLResult);
        return true;
    }

    public FetchGraphQLStoryMethod$FetchSingleStoryProcessor(FetchGraphQLStoryMethod fetchGraphQLStoryMethod, FetchSingleStoryParams fetchSingleStoryParams, DefaultCacheProcessor<GraphQLStory> defaultCacheProcessor, @Nullable String str, @Nullable FeedbackCacheProvider feedbackCacheProvider) {
        this.f10225f = fetchGraphQLStoryMethod;
        this.f10220a = fetchSingleStoryParams;
        this.f10221b = defaultCacheProcessor;
        this.f10222c = str;
        this.f10223d = feedbackCacheProvider;
    }

    public final GraphQLResult<GraphQLStory> m16012b(GraphQLResult graphQLResult) {
        Builder a;
        if (graphQLResult.e instanceof GraphQLPhoto) {
            a = Builder.a(graphQLResult);
            a.k = ((GraphQLPhoto) graphQLResult.e).C();
            graphQLResult = a.a();
        } else if (graphQLResult.e instanceof GraphQLVideo) {
            a = Builder.a(graphQLResult);
            a.k = ((GraphQLVideo) graphQLResult.e).z();
            graphQLResult = a.a();
        }
        if (graphQLResult.e == null || graphQLResult.freshness != DataFreshnessResult.FROM_SERVER) {
            return graphQLResult;
        }
        GraphQLResult a2;
        if (this.f10222c != null) {
            GraphQLStory.Builder a3 = GraphQLStory.Builder.a((GraphQLStory) graphQLResult.e);
            a3.o = this.f10222c;
            GraphQLStory a4 = a3.a();
            a = Builder.a(graphQLResult);
            a.k = a4;
            a2 = a.a();
        } else {
            a2 = graphQLResult;
        }
        FetchSingleStoryResult a5 = this.f10225f.l.a(new FetchSingleStoryResult((GraphQLStory) a2.e, a2.freshness, a2.clientTimeMs));
        if (!(a5 == null || a5.a == a2.e)) {
            a = Builder.a(a2);
            a.k = a5.a;
            a2 = a.a();
        }
        final long a6 = this.f10225f.j.a();
        FetchTimeMsHelper.a((GraphQLStory) a2.e, a6);
        if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER && this.f10223d != null) {
            for (a4 = (GraphQLStory) a2.e; a4 != null; a4 = a4.L()) {
                GraphQLFeedback l = a4.l();
                if (l != null) {
                    l.s = a6;
                    this.f10224e.add(l);
                }
            }
            if (!this.f10224e.isEmpty()) {
                for (GraphQLFeedback graphQLFeedback : this.f10224e) {
                    CacheProcessor a7 = this.f10223d.a(graphQLFeedback.z_());
                    Builder builder = new Builder();
                    builder.k = graphQLFeedback;
                    GraphQLResult a8 = builder.a();
                    if (1 != 0) {
                        a7.a(a8);
                    }
                }
            }
        }
        final Collection a9 = Sets.a();
        new GraphQLReadOnlyVisitor(this) {
            final /* synthetic */ FetchGraphQLStoryMethod$FetchSingleStoryProcessor f10219c;

            public final boolean m16008a(GraphQLVisitableModel graphQLVisitableModel) {
                if ((graphQLVisitableModel instanceof FeedUnit) && ((FeedUnit) graphQLVisitableModel).g() != null) {
                    a9.add(((FeedUnit) graphQLVisitableModel).g());
                }
                if (graphQLVisitableModel instanceof GraphQLFeedback) {
                    ((GraphQLFeedback) graphQLVisitableModel).s = a6;
                    GraphQLHelper.a((GraphQLFeedback) graphQLVisitableModel, true);
                }
                return true;
            }
        }.b((GraphQLVisitableModel) a2.e);
        return Builder.a(a2).a(a9).a();
    }

    public final GraphQLResult<GraphQLStory> m16009a() {
        GraphQLResult<GraphQLStory> a = this.f10221b.a();
        if (a != GraphQLQueryExecutor.a && a != null) {
            return a;
        }
        FetchSingleStoryResult a2;
        FetchSingleStoryResult fetchSingleStoryResult;
        if (this.f10220a.a != null) {
            a2 = this.f10225f.k.a(this.f10220a.a);
        } else {
            a2 = null;
        }
        if (a2 != null || this.f10220a.b == null) {
            fetchSingleStoryResult = a2;
        } else {
            fetchSingleStoryResult = this.f10225f.k.b(this.f10220a.b);
        }
        if (fetchSingleStoryResult == null || fetchSingleStoryResult.a == null) {
            return null;
        }
        return new GraphQLResult(fetchSingleStoryResult.a, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, fetchSingleStoryResult.clientTimeMs, this.f10225f.k.e(fetchSingleStoryResult.a));
    }

    public final GraphQLResult<GraphQLStory> m16010a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent) {
        GraphQLResult<GraphQLStory> a = m16009a();
        if (a != GraphQLQueryExecutor.a && a != null) {
            return a;
        }
        if (this.f10220a.b != null) {
            return GraphQLQueryExecutor.a;
        }
        return this.f10221b.a(graphQLQueryAnalyticsEvent);
    }
}
