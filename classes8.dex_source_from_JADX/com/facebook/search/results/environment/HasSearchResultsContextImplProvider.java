package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: StopEntityCardsScrollWaitTime_ */
public class HasSearchResultsContextImplProvider extends AbstractAssistedProvider<HasSearchResultsContextImpl> {
    public static HasSearchResultsContextImpl m26037a(SearchResultsMutableContext searchResultsMutableContext) {
        return new HasSearchResultsContextImpl(searchResultsMutableContext);
    }
}
