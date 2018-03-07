package com.facebook.feed.data;

import com.facebook.api.feed.module.Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider;
import com.facebook.api.feedcache.memory.FeedUnitTagHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: application/eia-608 */
public class FeedStorySubscriber {
    public final GraphQLSubscriptionHolder f19184a;
    public final Clock f19185b;
    private final boolean f19186c;
    public OnStoryChangeListener f19187d = null;

    /* compiled from: application/eia-608 */
    public interface OnStoryChangeListener {
        void mo1522a(GraphQLStory graphQLStory);
    }

    @VisibleForTesting
    /* compiled from: application/eia-608 */
    class UpdatedStoryCallback implements FutureCallback<GraphQLResult<FeedUnit>> {
        final /* synthetic */ FeedStorySubscriber f19181a;
        private boolean f19182b;
        private GraphQLStory f19183c;

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Object obj2 = 1;
            if (this.f19181a.f19187d != null && graphQLResult != null && (graphQLResult.e instanceof GraphQLStory)) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLResult.e;
                if (this.f19183c != graphQLStory && graphQLStory.g() != null && graphQLStory.g().equals(this.f19183c.g())) {
                    Object obj3 = graphQLStory.l() != this.f19183c.l() ? 1 : null;
                    if (!this.f19182b && graphQLStory.T_() == this.f19183c.T_()) {
                        obj2 = null;
                    }
                    if (obj3 != null || r2 != null) {
                        PropertyHelper.a(graphQLStory, null);
                        if (!this.f19182b) {
                            FetchTimeMsHelper.a(graphQLStory, this.f19181a.f19185b.a());
                        }
                        this.f19181a.f19187d.mo1522a(graphQLStory);
                        this.f19183c = graphQLStory;
                    }
                }
            }
        }

        public UpdatedStoryCallback(FeedStorySubscriber feedStorySubscriber, GraphQLStory graphQLStory, boolean z) {
            this.f19181a = feedStorySubscriber;
            this.f19182b = z;
            this.f19183c = graphQLStory;
        }

        public void onFailure(Throwable th) {
        }
    }

    public static FeedStorySubscriber m22696b(InjectorLike injectorLike) {
        return new FeedStorySubscriber(GraphQLSubscriptionHolder.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider.b(injectorLike));
    }

    @Inject
    public FeedStorySubscriber(GraphQLSubscriptionHolder graphQLSubscriptionHolder, Clock clock, Boolean bool) {
        this.f19184a = graphQLSubscriptionHolder;
        this.f19185b = clock;
        this.f19186c = bool.booleanValue();
    }

    public static FeedStorySubscriber m22695a(InjectorLike injectorLike) {
        return m22696b(injectorLike);
    }

    public final void m22698a(GraphQLStory graphQLStory) {
        m22699a(graphQLStory, false);
    }

    public final void m22699a(GraphQLStory graphQLStory, boolean z) {
        if (!this.f19184a.a(graphQLStory.c())) {
            GraphQLStory graphQLStory2 = graphQLStory;
            this.f19184a.a(new UpdatedStoryCallback(this, graphQLStory, z), graphQLStory.c(), new GraphQLResult(graphQLStory2, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, FeedUnitTagHelper.a(graphQLStory, this.f19186c)));
            this.f19184a.e();
        }
    }

    public final void m22697a() {
        this.f19187d = null;
        this.f19184a.a();
    }

    public final void m22700b() {
        this.f19184a.b();
    }
}
