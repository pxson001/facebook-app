package com.facebook.search.results.fragment.controllers;

import com.facebook.content.event.FbEvent;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.search.results.environment.SearchResultsEnvironment;
import javax.inject.Inject;

/* compiled from: SHOW_HIDE_PASSWORD */
public class SearchResultsMutationsController extends BaseController implements ResumePauseCallbacks {
    private final FeedEventBus f22997a;
    public SearchResultsEnvironment f22998b;
    public FeedUnitMutatedEventSubscriber f22999c;

    /* compiled from: SHOW_HIDE_PASSWORD */
    public class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ SearchResultsMutationsController f22996a;

        public FeedUnitMutatedEventSubscriber(SearchResultsMutationsController searchResultsMutationsController) {
            this.f22996a = searchResultsMutationsController;
        }

        public final void m26629b(FbEvent fbEvent) {
            FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
            if ((feedUnitMutatedEvent.a instanceof GraphQLStory) && this.f22996a.f22998b.mo1244a(feedUnitMutatedEvent.a)) {
                this.f22996a.f22998b.mo1242a((GraphQLStory) feedUnitMutatedEvent.a);
                this.f22996a.f22998b.hL_();
            }
        }
    }

    @Inject
    public SearchResultsMutationsController(FeedEventBus feedEventBus) {
        this.f22997a = feedEventBus;
    }

    public final void m26630c() {
        FeedEventBus feedEventBus = this.f22997a;
        if (this.f22999c == null) {
            this.f22999c = new FeedUnitMutatedEventSubscriber(this);
        }
        feedEventBus.a(this.f22999c);
    }

    public final void m26631d() {
        this.f22997a.b(this.f22999c);
    }
}
