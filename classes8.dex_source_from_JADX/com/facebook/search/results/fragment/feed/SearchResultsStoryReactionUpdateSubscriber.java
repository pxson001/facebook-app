package com.facebook.search.results.fragment.feed;

import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.rows.events.SearchResultsStoryReactionUpdatedEvent;
import com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEvent;
import com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEventSubscriber;
import javax.inject.Inject;

/* compiled from: SESSION_ID_MISMATCH */
public class SearchResultsStoryReactionUpdateSubscriber extends ReactionUpdatedEventSubscriber {
    private final SearchResultsFeedCollection f23056a;
    private final EventsStream f23057b;

    public final void m26716b(FbEvent fbEvent) {
        ReactionUpdatedEvent reactionUpdatedEvent = (ReactionUpdatedEvent) fbEvent;
        FeedProps a = this.f23056a.m27053a(reactionUpdatedEvent.b);
        if (a != null) {
            this.f23057b.a(new SearchResultsStoryReactionUpdatedEvent(a, reactionUpdatedEvent.a, reactionUpdatedEvent.c));
        }
    }

    @Inject
    public SearchResultsStoryReactionUpdateSubscriber(@Assisted SearchResultsFeedCollection searchResultsFeedCollection, EventsStream eventsStream) {
        this.f23056a = searchResultsFeedCollection;
        this.f23057b = eventsStream;
    }
}
