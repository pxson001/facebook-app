package com.facebook.feed.ui.feedprefetch;

import com.facebook.api.prefetch.GraphQLPrefetchPriority;
import com.facebook.api.prefetch.GraphQLPrefetcher;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.ui.feedprefetch.FeedPrefetchLoader.FeedbackContextVisitor;
import com.facebook.graphql.enums.GraphQLFeedbackReadLikelihood;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackContext;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* compiled from: TopicFeedList */
class FeedPrefetchLoader$FeedbackContextVisitorNoRefactor extends FeedbackContextVisitor {
    final /* synthetic */ FeedPrefetchLoader f21882c;
    private final Map<GraphQLFeedbackReadLikelihood, GraphQLPrefetchPriority> f21883d = ImmutableMap.of(GraphQLFeedbackReadLikelihood.UNKNOWN, GraphQLPrefetchPriority.UNKNOWN, GraphQLFeedbackReadLikelihood.LOW, GraphQLPrefetchPriority.LOW, GraphQLFeedbackReadLikelihood.HIGH, GraphQLPrefetchPriority.HIGH);
    private GraphQLPrefetcher f21884e;
    private GraphQLPrefetcher f21885f;

    public FeedPrefetchLoader$FeedbackContextVisitorNoRefactor(FeedPrefetchLoader feedPrefetchLoader, GraphQLPrefetcher graphQLPrefetcher, GraphQLPrefetcher graphQLPrefetcher2) {
        this.f21882c = feedPrefetchLoader;
        super(feedPrefetchLoader);
        this.f21884e = graphQLPrefetcher;
        this.f21885f = graphQLPrefetcher2;
    }

    public final void m24467a(GraphQLStory graphQLStory) {
        GraphQLPrefetcher graphQLPrefetcher;
        boolean a = this.f21882c.d.a(ExperimentsForNewsFeedAbTestModule.t, false);
        GraphQLFeedback l = graphQLStory.l();
        GraphQLFeedbackContext aa = graphQLStory.aa();
        GraphQLPrefetcher graphQLPrefetcher2 = this.f21884e;
        boolean a2 = this.f21882c.i.a();
        if (GraphQLHelper.o(graphQLStory) && a2) {
            graphQLPrefetcher = this.f21885f;
        } else {
            graphQLPrefetcher = graphQLPrefetcher2;
        }
        if (!a) {
            if (aa != null && !aa.m().isEmpty() && this.f21882c.a.a() && (!this.f21882c.a.c() || this.a == DataFreshnessResult.FROM_SERVER)) {
                GraphQLFeedback graphQLFeedback = l;
                while (graphQLFeedback == null) {
                    GraphQLStory L = graphQLStory.L();
                    if (L == null) {
                        break;
                    }
                    graphQLFeedback = L.l();
                }
                if (graphQLFeedback != null) {
                    graphQLPrefetcher.a(GraphQLPrefetchPriority.HIGH, graphQLFeedback.z_());
                }
            }
            if (l != null) {
                m24466a(graphQLPrefetcher, l);
                if (aa != null && GraphQLHelper.f(l) > 0) {
                    GraphQLPrefetchPriority graphQLPrefetchPriority = (GraphQLPrefetchPriority) this.f21883d.get(aa.n());
                    if (graphQLPrefetchPriority == null) {
                        graphQLPrefetchPriority = GraphQLPrefetchPriority.UNKNOWN;
                    }
                    graphQLPrefetcher.a(graphQLPrefetchPriority, l.z_());
                }
            }
        } else if (l != null) {
            m24466a(graphQLPrefetcher, l);
        }
    }

    private void m24466a(GraphQLPrefetcher graphQLPrefetcher, GraphQLFeedback graphQLFeedback) {
        boolean z = true;
        boolean z2 = GraphQLHelper.f(graphQLFeedback) == 0 && this.f21882c.d.a(ExperimentsForNewsFeedAbTestModule.o, false) && !this.f21882c.d.a(ExperimentsForNewsFeedAbTestModule.v, false);
        if (z2) {
            graphQLPrefetcher.a(graphQLFeedback);
        }
        if (GraphQLHelper.f(graphQLFeedback) <= 0 || !this.f21882c.d.a(ExperimentsForNewsFeedAbTestModule.n, false) || this.f21882c.d.a(ExperimentsForNewsFeedAbTestModule.v, false)) {
            z = false;
        }
        if (z) {
            graphQLPrefetcher.b(graphQLFeedback);
        }
    }
}
