package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;

/* compiled from: System-Italic */
public class CanReplaceFeedItemEntitiesImplProvider extends AbstractAssistedProvider<CanReplaceFeedItemEntitiesImpl> {
    public static CanReplaceFeedItemEntitiesImpl m26003a(SearchResultsEntitiesCollection searchResultsEntitiesCollection, HasFeedItemPosition hasFeedItemPosition) {
        return new CanReplaceFeedItemEntitiesImpl(searchResultsEntitiesCollection, hasFeedItemPosition);
    }
}
