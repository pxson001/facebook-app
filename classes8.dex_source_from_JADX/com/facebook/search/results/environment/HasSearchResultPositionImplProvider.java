package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsCollection;

/* compiled from: StoryZombies */
public class HasSearchResultPositionImplProvider extends AbstractAssistedProvider<HasSearchResultPositionImpl> {
    public static HasSearchResultPositionImpl m26034a(SearchResultsCollection searchResultsCollection) {
        return new HasSearchResultPositionImpl(searchResultsCollection);
    }
}
