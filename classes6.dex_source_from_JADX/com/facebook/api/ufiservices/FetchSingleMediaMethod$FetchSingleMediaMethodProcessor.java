package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.FeedbackCacheProvider;
import com.facebook.api.ufiservices.common.FetchSingleMediaParams;
import com.facebook.api.ufiservices.common.FetchSingleMediaParams.FetchType;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.DefaultCacheProcessor;
import com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.ufiservices.data.DefaultFeedbackCacheProvider;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import javax.annotation.Nullable;

/* compiled from: promo_id */
public class FetchSingleMediaMethod$FetchSingleMediaMethodProcessor implements CacheProcessor<GraphQLMedia> {
    final FetchSingleMediaParams f7190a;
    DefaultCacheProcessor<GraphQLMedia> f7191b;
    public DefaultFeedbackCacheProvider f7192c;
    public GraphQLFeedback f7193d;
    final /* synthetic */ FetchSingleMediaMethod f7194e;

    public FetchSingleMediaMethod$FetchSingleMediaMethodProcessor(FetchSingleMediaMethod fetchSingleMediaMethod, FetchSingleMediaParams fetchSingleMediaParams, DefaultCacheProcessor<GraphQLMedia> defaultCacheProcessor, @Nullable FeedbackCacheProvider feedbackCacheProvider) {
        this.f7194e = fetchSingleMediaMethod;
        this.f7190a = fetchSingleMediaParams;
        this.f7191b = defaultCacheProcessor;
        this.f7192c = feedbackCacheProvider;
    }

    public final GraphQLResult<GraphQLMedia> m10342a() {
        return this.f7191b.a();
    }

    public final GraphQLResult<GraphQLMedia> m10343a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent) {
        return this.f7191b.a(graphQLQueryAnalyticsEvent);
    }

    public final GraphQLResult<GraphQLMedia> m10345b(GraphQLResult<GraphQLMedia> graphQLResult) {
        FetchSingleMediaMethod fetchSingleMediaMethod = this.f7194e;
        GraphQLMedia graphQLMedia = (GraphQLMedia) graphQLResult.e;
        if (graphQLMedia.I() != null) {
            graphQLMedia.I().s = fetchSingleMediaMethod.c.a();
        }
        if (!(((GraphQLMedia) graphQLResult.e).I() == null || Strings.isNullOrEmpty(((GraphQLMedia) graphQLResult.e).I().j()))) {
            graphQLResult = Builder.a(graphQLResult).a(Sets.a(new String[]{((GraphQLMedia) graphQLResult.e).I().j()})).a();
        }
        if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER && this.f7190a.c == FetchType.COMPLETE && this.f7192c != null && ((GraphQLMedia) graphQLResult.e).I() != null) {
            this.f7193d = ((GraphQLMedia) graphQLResult.e).I();
            this.f7193d.s = this.f7194e.c.a();
            if (this.f7193d != null) {
                CacheProcessor a = this.f7192c.a(this.f7193d.z_());
                Builder builder = new Builder();
                builder.k = this.f7193d;
                GraphQLResult a2 = builder.a();
                if (1 != null) {
                    a.a(a2);
                }
            }
        }
        return graphQLResult;
    }

    public final boolean m10344a(GraphQLResult<GraphQLMedia> graphQLResult) {
        if (!(graphQLResult.e == null || ((GraphQLMedia) graphQLResult.e).I() == null)) {
            this.f7194e.e.a(((GraphQLMedia) graphQLResult.e).I());
        }
        this.f7191b.a(graphQLResult);
        if (graphQLResult.e == null || ((GraphQLMedia) graphQLResult.e).I() == null) {
            return false;
        }
        return true;
    }
}
