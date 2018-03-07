package com.facebook.search.results.environment;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsFeedCollection;

/* compiled from: Succeeded to fetch video ad */
public class HasFeedItemPositionFeedImplProvider extends AbstractAssistedProvider<HasFeedItemPositionFeedImpl> {
    public static HasFeedItemPositionFeedImpl m26024a(SearchResultsFeedCollection searchResultsFeedCollection) {
        return new HasFeedItemPositionFeedImpl(searchResultsFeedCollection);
    }
}
