package com.facebook.search.results.fragment.feed;

import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: SHARE_EVENT_TAP */
public class SearchResultsFeedEventsManagerProvider extends AbstractAssistedProvider<SearchResultsFeedEventsManager> {
    public final SearchResultsFeedEventsManager m26650a(SearchResultsMutableContext searchResultsMutableContext, SearchResultsFeedCollection searchResultsFeedCollection, SearchResultsFeedEnvironmentGenerated searchResultsFeedEnvironmentGenerated) {
        SearchResultsFeedEventsManager searchResultsFeedEventsManager = new SearchResultsFeedEventsManager(searchResultsMutableContext, searchResultsFeedCollection, searchResultsFeedEnvironmentGenerated, EventsStream.a(this), FeedEventBus.a(this), SearchResultsLogger.m25460a((InjectorLike) this), GraphSearchErrorReporter.a(this));
        Lazy a = IdBasedLazy.a(this, 10607);
        Lazy a2 = IdBasedLazy.a(this, 5410);
        Lazy a3 = IdBasedLazy.a(this, 1779);
        Lazy b = IdBasedSingletonScopeProvider.b(this, 1477);
        searchResultsFeedEventsManager.f23016c = a;
        searchResultsFeedEventsManager.f23023j = a2;
        searchResultsFeedEventsManager.f23024k = a3;
        searchResultsFeedEventsManager.f23025l = b;
        return searchResultsFeedEventsManager;
    }
}
