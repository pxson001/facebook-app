package com.facebook.timeline.units;

import com.facebook.api.feedcache.memory.FeedUnitTagHelper;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.Assisted;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineUnitsMutationCallbacks;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_instant_shopping_product_id */
public class TimelineUnitSubscriber {
    public final TimelineAllSectionsData f12753a;
    public final TimelineStoriesDataFetcher f12754b;
    private final Provider<GraphQLSubscriptionHolder> f12755c;
    private final boolean f12756d;
    @Nullable
    public GraphQLSubscriptionHolder f12757e;
    private final FutureCallback<GraphQLResult<GraphQLStory>> f12758f = new C17881(this);
    private final FutureCallback<GraphQLResult<GraphQLFeedback>> f12759g = new C17892(this);

    /* compiled from: extra_instant_shopping_product_id */
    class C17881 implements FutureCallback<GraphQLResult<GraphQLStory>> {
        final /* synthetic */ TimelineUnitSubscriber f12751a;

        C17881(TimelineUnitSubscriber timelineUnitSubscriber) {
            this.f12751a = timelineUnitSubscriber;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null) {
                TimelineUnitSubscriber timelineUnitSubscriber = this.f12751a;
                timelineUnitSubscriber.f12753a.m12716a((GraphQLStory) graphQLResult.e);
                timelineUnitSubscriber.f12754b.m10727f();
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: extra_instant_shopping_product_id */
    class C17892 implements FutureCallback<GraphQLResult<GraphQLFeedback>> {
        final /* synthetic */ TimelineUnitSubscriber f12752a;

        C17892(TimelineUnitSubscriber timelineUnitSubscriber) {
            this.f12752a = timelineUnitSubscriber;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null) {
                TimelineUnitSubscriber timelineUnitSubscriber = this.f12752a;
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLResult.e;
                Feedbackable a = timelineUnitSubscriber.f12753a.m12712a(null, graphQLFeedback.j());
                if (a != null) {
                    timelineUnitSubscriber.f12753a.m12717a(a, graphQLFeedback);
                    timelineUnitSubscriber.f12754b.m10727f();
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    @Inject
    public TimelineUnitSubscriber(@Assisted TimelineUnitsMutationCallbacks timelineUnitsMutationCallbacks, @Assisted TimelineStoriesDataFetcher timelineStoriesDataFetcher, Boolean bool, Provider<GraphQLSubscriptionHolder> provider) {
        this.f12753a = (TimelineAllSectionsData) Preconditions.checkNotNull(timelineUnitsMutationCallbacks);
        this.f12754b = (TimelineStoriesDataFetcher) Preconditions.checkNotNull(timelineStoriesDataFetcher);
        this.f12756d = bool.booleanValue();
        this.f12755c = provider;
    }

    public final void m12703a(Iterable iterable) {
        for (Object next : iterable) {
            if (next instanceof GraphQLStory) {
                m12702a((GraphQLStory) next);
            }
        }
    }

    public final void m12702a(GraphQLStory graphQLStory) {
        String c = graphQLStory.c();
        m12700b(graphQLStory);
        m12701d().a(this.f12758f, c, new GraphQLResult(graphQLStory, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, FeedUnitTagHelper.a(graphQLStory, this.f12756d)));
    }

    private void m12700b(GraphQLStory graphQLStory) {
        if (!(graphQLStory.l() == null || graphQLStory.l().z_() == null || graphQLStory.l().j() == null)) {
            m12701d().a(this.f12759g, graphQLStory.l().z_(), new GraphQLResult(graphQLStory.l(), DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, ImmutableSet.of(graphQLStory.l().j())));
        }
        if (!(StoryHierarchyHelper.a(graphQLStory) == null || StoryHierarchyHelper.a(graphQLStory).j() == null)) {
            ImmutableList j = StoryHierarchyHelper.a(graphQLStory).j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                m12700b((GraphQLStory) j.get(i));
            }
        }
        if (graphQLStory.L() != null) {
            m12700b(graphQLStory.L());
        }
    }

    private GraphQLSubscriptionHolder m12701d() {
        if (this.f12757e == null) {
            this.f12757e = (GraphQLSubscriptionHolder) this.f12755c.get();
        }
        return this.f12757e;
    }
}
