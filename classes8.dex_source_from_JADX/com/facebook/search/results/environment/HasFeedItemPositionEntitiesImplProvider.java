package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;

/* compiled from: Successfully cleared null state searches cache! */
public class HasFeedItemPositionEntitiesImplProvider extends AbstractAssistedProvider<HasFeedItemPositionEntitiesImpl> {
    public static HasFeedItemPositionEntitiesImpl m26022a(SearchResultsEntitiesCollection searchResultsEntitiesCollection) {
        return new HasFeedItemPositionEntitiesImpl(searchResultsEntitiesCollection);
    }
}
