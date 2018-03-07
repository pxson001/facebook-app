package com.facebook.search.results.environment;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import javax.inject.Inject;

/* compiled from: Successfully Fetched  */
public class HasFeedItemPositionFeedImpl implements HasFeedItemPosition {
    private final SearchResultsFeedCollection f22543a;

    @Inject
    public HasFeedItemPositionFeedImpl(@Assisted SearchResultsFeedCollection searchResultsFeedCollection) {
        this.f22543a = searchResultsFeedCollection;
    }

    public final int mo1245a(Object obj) {
        return obj instanceof FeedUnit ? this.f22543a.m27064b((FeedUnit) obj) : -1;
    }
}
