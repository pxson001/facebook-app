package com.facebook.search.results.environment.entity;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsFeedCollection;

/* compiled from: SearchTypeahead */
public class CanProvideRoleForEntityFeedImplProvider extends AbstractAssistedProvider<CanProvideRoleForEntityFeedImpl> {
    public static CanProvideRoleForEntityFeedImpl m26238a(SearchResultsFeedCollection searchResultsFeedCollection) {
        return new CanProvideRoleForEntityFeedImpl(searchResultsFeedCollection);
    }
}
