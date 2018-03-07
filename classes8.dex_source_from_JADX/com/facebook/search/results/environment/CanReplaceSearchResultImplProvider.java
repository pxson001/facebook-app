package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsCollection;

/* compiled from: SuggestProfilePicFragment.media_item */
public class CanReplaceSearchResultImplProvider extends AbstractAssistedProvider<CanReplaceSearchResultImpl> {
    public static CanReplaceSearchResultImpl m26018a(SearchResultsCollection searchResultsCollection, HasSearchResultPosition hasSearchResultPosition) {
        return new CanReplaceSearchResultImpl(searchResultsCollection, hasSearchResultPosition);
    }
}
