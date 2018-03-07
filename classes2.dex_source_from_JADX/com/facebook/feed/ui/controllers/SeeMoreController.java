package com.facebook.feed.ui.controllers;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.data.AggregatedSubstoriesFetcher;
import com.facebook.feed.data.AggregatedSubstoriesFetcher.1;
import com.facebook.feed.data.AggregatedSubstoriesFetcher.2;
import com.facebook.feed.util.event.StoryEvents$PaginatedSeeMoreAggregatedStoryEvent;
import com.facebook.feed.util.event.StoryEvents$PaginatedSeeMoreAggregatedStoryEventSubscriber;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

@ContextScoped
/* compiled from: platform_cleanup_cached_webdialogs */
public class SeeMoreController {
    private static SeeMoreController f9721d;
    private static final Object f9722e = new Object();
    public final AggregatedSubstoriesFetcher f9723a;
    public final SeeMoreAggregatedStorySubscriber f9724b = new SeeMoreAggregatedStorySubscriber(this);
    public FutureCallback<GraphQLStory> f9725c;

    /* compiled from: platform_cleanup_cached_webdialogs */
    public class SeeMoreAggregatedStorySubscriber extends StoryEvents$PaginatedSeeMoreAggregatedStoryEventSubscriber {
        final /* synthetic */ SeeMoreController f9734a;

        public SeeMoreAggregatedStorySubscriber(SeeMoreController seeMoreController) {
            this.f9734a = seeMoreController;
        }

        public final void mo650b(FbEvent fbEvent) {
            StoryEvents$PaginatedSeeMoreAggregatedStoryEvent storyEvents$PaginatedSeeMoreAggregatedStoryEvent = (StoryEvents$PaginatedSeeMoreAggregatedStoryEvent) fbEvent;
            AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher = this.f9734a.f9723a;
            GraphQLStory graphQLStory = storyEvents$PaginatedSeeMoreAggregatedStoryEvent.f13916a;
            int i = storyEvents$PaginatedSeeMoreAggregatedStoryEvent.f13917b;
            FutureCallback futureCallback = this.f9734a.f9725c;
            if (graphQLStory != null && futureCallback != null && aggregatedSubstoriesFetcher.f9727a.m3828d()) {
                aggregatedSubstoriesFetcher.f9732f.m14556a(null, new 1(aggregatedSubstoriesFetcher, graphQLStory, Math.min(i, StoryHierarchyHelper.m27434a(graphQLStory).m22610l())), new 2(aggregatedSubstoriesFetcher, graphQLStory, futureCallback));
            }
        }
    }

    private static SeeMoreController m14736b(InjectorLike injectorLike) {
        return new SeeMoreController(AggregatedSubstoriesFetcher.m14738a(injectorLike));
    }

    @Inject
    public SeeMoreController(AggregatedSubstoriesFetcher aggregatedSubstoriesFetcher) {
        this.f9723a = aggregatedSubstoriesFetcher;
    }

    public final void m14737b() {
        this.f9725c = null;
    }

    public static SeeMoreController m14735a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeMoreController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9722e) {
                SeeMoreController seeMoreController;
                if (a2 != null) {
                    seeMoreController = (SeeMoreController) a2.mo818a(f9722e);
                } else {
                    seeMoreController = f9721d;
                }
                if (seeMoreController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14736b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9722e, b3);
                        } else {
                            f9721d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = seeMoreController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
