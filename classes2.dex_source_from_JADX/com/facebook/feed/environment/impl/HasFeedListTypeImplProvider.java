package com.facebook.feed.environment.impl;

import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: news_feed_events */
public class HasFeedListTypeImplProvider extends AbstractAssistedProvider<HasFeedListTypeImpl> {
    public static HasFeedListTypeImpl m18332a(FeedListType feedListType) {
        return new HasFeedListTypeImpl(feedListType);
    }
}
