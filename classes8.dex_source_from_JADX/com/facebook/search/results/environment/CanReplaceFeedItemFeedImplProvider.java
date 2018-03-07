package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsFeedCollection;

/* compiled from: Surface '%s' did an entities fetch that returned a bad set of results. Expected IDs [%s] but got entities for [%s] */
public class CanReplaceFeedItemFeedImplProvider extends AbstractAssistedProvider<CanReplaceFeedItemFeedImpl> {
    public static CanReplaceFeedItemFeedImpl m26005a(SearchResultsFeedCollection searchResultsFeedCollection) {
        return new CanReplaceFeedItemFeedImpl(searchResultsFeedCollection);
    }
}
