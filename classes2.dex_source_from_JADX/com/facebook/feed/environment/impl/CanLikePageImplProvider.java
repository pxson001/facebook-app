package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: newsfeed container is not in a CoordinatorLayout */
public class CanLikePageImplProvider extends AbstractAssistedProvider<CanLikePageImpl> {
    public final CanLikePageImpl m18309a(HasFeedListType hasFeedListType) {
        return new CanLikePageImpl(FeedEventBus.m4573a(this), hasFeedListType);
    }
}
