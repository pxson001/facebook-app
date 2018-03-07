package com.facebook.search.results.fragment.controllers;

import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: SHOW_MAP */
public class SearchResultsControllerCallbacksDispatcherFactory {
    @Inject
    public SearchResultsMutationsController f22995a;

    public static SearchResultsControllerCallbacksDispatcherFactory m26628a(InjectorLike injectorLike) {
        SearchResultsControllerCallbacksDispatcherFactory searchResultsControllerCallbacksDispatcherFactory = new SearchResultsControllerCallbacksDispatcherFactory();
        searchResultsControllerCallbacksDispatcherFactory.f22995a = new SearchResultsMutationsController(FeedEventBus.a(injectorLike));
        return searchResultsControllerCallbacksDispatcherFactory;
    }
}
