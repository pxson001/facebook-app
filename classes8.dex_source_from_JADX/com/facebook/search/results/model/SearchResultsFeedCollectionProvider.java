package com.facebook.search.results.model;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.common.errors.GraphSearchErrorReporter;

/* compiled from: SAVE_HISTORY_SETTING */
public class SearchResultsFeedCollectionProvider extends AbstractAssistedProvider<SearchResultsFeedCollection> {
    public final SearchResultsFeedCollection m27076a(SearchResultsMutableContext searchResultsMutableContext) {
        return new SearchResultsFeedCollection(searchResultsMutableContext, GraphSearchErrorReporter.a(this));
    }
}
