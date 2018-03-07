package com.facebook.search.results.environment.entity;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;

/* compiled from: Segues */
public class CanLogEntityNavigationEntitiesImplProvider extends AbstractAssistedProvider<CanLogEntityNavigationEntitiesImpl> {
    public final CanLogEntityNavigationEntitiesImpl m26229a(HasSearchResultsContext hasSearchResultsContext, HasSearchResultPosition hasSearchResultPosition) {
        return new CanLogEntityNavigationEntitiesImpl(hasSearchResultsContext, hasSearchResultPosition, SearchResultsLogger.m25460a((InjectorLike) this));
    }
}
