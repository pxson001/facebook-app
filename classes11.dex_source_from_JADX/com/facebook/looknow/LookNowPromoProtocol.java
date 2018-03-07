package com.facebook.looknow;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge.Builder;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.looknow.LookNowAnalyticsLogger.Events;
import com.facebook.looknow.LookNowPermalinkFragment.C00421;
import com.facebook.looknow.protocol.FetchLookNowStoryGraphQL.LookNowStoryQueryString;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: utm_uid */
public class LookNowPromoProtocol {
    public final Function<GraphQLResult<GraphQLCustomizedStory>, GraphQLFeedUnitEdge> f263a = new C00441(this);
    public final Executor f264b;
    public final GraphQLQueryExecutor f265c;
    public final FeedUnitCollection f266d;
    private final TasksManager f267e;
    public final FetchFeedQueryUtil f268f;
    public C00421 f269g;

    /* compiled from: utm_uid */
    class C00441 implements Function<GraphQLResult<GraphQLCustomizedStory>, GraphQLFeedUnitEdge> {
        final /* synthetic */ LookNowPromoProtocol f261a;

        C00441(LookNowPromoProtocol lookNowPromoProtocol) {
            this.f261a = lookNowPromoProtocol;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            LookNowPromoProtocol lookNowPromoProtocol = this.f261a;
            if (graphQLResult == null || graphQLResult.e == null) {
                graphQLFeedUnitEdge = null;
            } else {
                Builder builder = new Builder();
                builder.i = (FeedUnit) graphQLResult.e;
                builder = builder;
                builder.f = ((GraphQLCustomizedStory) graphQLResult.e).a();
                graphQLFeedUnitEdge = builder.a();
            }
            return graphQLFeedUnitEdge;
        }
    }

    /* compiled from: utm_uid */
    class LoadStoriesCallback extends AbstractDisposableFutureCallback<GraphQLFeedUnitEdge> {
        final /* synthetic */ LookNowPromoProtocol f262a;

        public LoadStoriesCallback(LookNowPromoProtocol lookNowPromoProtocol) {
            this.f262a = lookNowPromoProtocol;
        }

        protected final void m290a(Object obj) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) obj;
            if (graphQLFeedUnitEdge != null) {
                this.f262a.f266d.b(graphQLFeedUnitEdge);
            }
            this.f262a.f269g.m280a(false);
        }

        protected final void m291a(Throwable th) {
            C00421 c00421 = this.f262a.f269g;
            c00421.f250a.f259h.m276a(Events.LOOK_NOW_PERMALINK_LOAD_FAILURE, th.getMessage());
            c00421.f250a.am.a(c00421.f250a.b(2131242230), null);
        }
    }

    public static LookNowPromoProtocol m292b(InjectorLike injectorLike) {
        return new LookNowPromoProtocol((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), FeedUnitCollection.b(injectorLike), TasksManager.b(injectorLike), FetchFeedQueryUtil.a(injectorLike));
    }

    @Inject
    public LookNowPromoProtocol(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, FeedUnitCollection feedUnitCollection, TasksManager tasksManager, FetchFeedQueryUtil fetchFeedQueryUtil) {
        this.f264b = executorService;
        this.f265c = graphQLQueryExecutor;
        this.f266d = feedUnitCollection;
        this.f267e = tasksManager;
        this.f268f = fetchFeedQueryUtil;
    }

    public final void m293a() {
        TasksManager tasksManager = this.f267e;
        Integer valueOf = Integer.valueOf(0);
        this.f269g.m280a(true);
        GraphQlQueryString lookNowStoryQueryString = new LookNowStoryQueryString();
        this.f268f.a(lookNowStoryQueryString);
        this.f268f.b(lookNowStoryQueryString);
        this.f268f.c(lookNowStoryQueryString);
        FetchFeedQueryUtil.d(lookNowStoryQueryString);
        tasksManager.a(valueOf, Futures.a(this.f265c.a(GraphQLRequest.a(lookNowStoryQueryString).a(GraphQLCachePolicy.c)), this.f263a, this.f264b), new LoadStoriesCallback(this));
    }
}
