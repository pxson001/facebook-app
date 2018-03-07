package com.facebook.search.results.fragment.feed;

import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.rows.events.SearchResultsStoryLikeEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import javax.inject.Inject;

/* compiled from: SETTINGS_TOKEN */
public class SearchResultsStoryLikeClickSubscriber extends LikeClickedEventSubscriber {
    private final SearchResultsFeedCollection f23054a;
    private final EventsStream f23055b;

    public final void m26715b(FbEvent fbEvent) {
        LikeClickedEvent likeClickedEvent = (LikeClickedEvent) fbEvent;
        FeedProps a = this.f23054a.m27053a(likeClickedEvent.a);
        if (a != null) {
            this.f23055b.a(new SearchResultsStoryLikeEvent(a, likeClickedEvent.d));
        }
    }

    @Inject
    public SearchResultsStoryLikeClickSubscriber(@Assisted SearchResultsFeedCollection searchResultsFeedCollection, EventsStream eventsStream) {
        this.f23054a = searchResultsFeedCollection;
        this.f23055b = eventsStream;
    }
}
