package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsFeedCollection;

/* compiled from: SuggestedCitiesQuery */
public class CanReplaceSearchResultFeedImplProvider extends AbstractAssistedProvider<CanReplaceSearchResultFeedImpl> {
    public static CanReplaceSearchResultFeedImpl m26012a(SearchResultsFeedCollection searchResultsFeedCollection, HasSearchResultPosition hasSearchResultPosition) {
        return new CanReplaceSearchResultFeedImpl(searchResultsFeedCollection, hasSearchResultPosition);
    }
}
