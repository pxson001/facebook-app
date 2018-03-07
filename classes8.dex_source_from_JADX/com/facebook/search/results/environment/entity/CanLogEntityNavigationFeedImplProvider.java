package com.facebook.search.results.environment.entity;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: See what's happening by neighborhood */
public class CanLogEntityNavigationFeedImplProvider extends AbstractAssistedProvider<CanLogEntityNavigationFeedImpl> {
    public final CanLogEntityNavigationFeedImpl m26231a(SearchResultsMutableContext searchResultsMutableContext, SearchResultsFeedCollection searchResultsFeedCollection) {
        return new CanLogEntityNavigationFeedImpl(searchResultsMutableContext, searchResultsFeedCollection, SearchResultsLogger.m25460a((InjectorLike) this), GraphSearchErrorReporter.a(this));
    }
}
