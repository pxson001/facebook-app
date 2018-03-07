package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsFeedCollection;

/* compiled from: StyleNone */
public class HasSearchResultPositionFeedImplProvider extends AbstractAssistedProvider<HasSearchResultPositionFeedImpl> {
    public static HasSearchResultPositionFeedImpl m26031a(SearchResultsFeedCollection searchResultsFeedCollection) {
        return new HasSearchResultPositionFeedImpl(searchResultsFeedCollection);
    }
}
