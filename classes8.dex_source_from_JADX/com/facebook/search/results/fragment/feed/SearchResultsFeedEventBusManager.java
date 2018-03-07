package com.facebook.search.results.fragment.feed;

import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import javax.inject.Inject;

/* compiled from: SHOW_BOTTOM */
public class SearchResultsFeedEventBusManager {
    public final SearchResultsFeedCollection f23003a;
    public final FeedEventBus f23004b;
    public final SearchResultsStoryLikeClickSubscriberProvider f23005c;
    public final SearchResultsStoryReactionUpdateSubscriberProvider f23006d;
    public final FbEventSubscriberListManager f23007e = new FbEventSubscriberListManager();

    @Inject
    public SearchResultsFeedEventBusManager(@Assisted SearchResultsFeedCollection searchResultsFeedCollection, FeedEventBus feedEventBus, SearchResultsStoryLikeClickSubscriberProvider searchResultsStoryLikeClickSubscriberProvider, SearchResultsStoryReactionUpdateSubscriberProvider searchResultsStoryReactionUpdateSubscriberProvider) {
        this.f23003a = searchResultsFeedCollection;
        this.f23004b = feedEventBus;
        this.f23005c = searchResultsStoryLikeClickSubscriberProvider;
        this.f23006d = searchResultsStoryReactionUpdateSubscriberProvider;
        FbEventSubscriberListManager fbEventSubscriberListManager = this.f23007e;
        r2 = new FbEventSubscriber[2];
        r2[0] = new SearchResultsStoryLikeClickSubscriber(this.f23003a, EventsStream.a(this.f23005c));
        r2[1] = new SearchResultsStoryReactionUpdateSubscriber(this.f23003a, EventsStream.a(this.f23006d));
        fbEventSubscriberListManager.a(r2);
    }
}
