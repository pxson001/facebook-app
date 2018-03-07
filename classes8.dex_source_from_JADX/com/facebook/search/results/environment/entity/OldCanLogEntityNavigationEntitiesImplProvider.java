package com.facebook.search.results.environment.entity;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;

/* compiled from: SearchResultsCollectionUnit{mDisplayStyle= */
public class OldCanLogEntityNavigationEntitiesImplProvider extends AbstractAssistedProvider<OldCanLogEntityNavigationEntitiesImpl> {
    public final OldCanLogEntityNavigationEntitiesImpl m26248a(HasSearchResultsContext hasSearchResultsContext, HasFeedItemPosition hasFeedItemPosition) {
        return new OldCanLogEntityNavigationEntitiesImpl(hasSearchResultsContext, hasFeedItemPosition, SearchResultsLogger.m25460a((InjectorLike) this));
    }
}
