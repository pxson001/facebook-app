package com.facebook.search.results.environment.common;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: SendPageLikeInviteMethod */
public class CanLogCollectionItemNavigationImplProvider extends AbstractAssistedProvider<CanLogCollectionItemNavigationImpl> {
    public final CanLogCollectionItemNavigationImpl m26221a(SearchResultsMutableContext searchResultsMutableContext, SearchResultsFeedCollection searchResultsFeedCollection) {
        return new CanLogCollectionItemNavigationImpl(searchResultsMutableContext, searchResultsFeedCollection, SearchResultsLogger.m25460a((InjectorLike) this));
    }
}
