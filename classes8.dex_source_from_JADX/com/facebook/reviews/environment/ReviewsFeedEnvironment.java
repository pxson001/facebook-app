package com.facebook.reviews.environment;

import android.content.Context;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import com.facebook.reviews.controller.ReviewStoriesFeedController;
import com.facebook.reviews.feed.ReviewsFeedStoryMenuHelper;
import com.facebook.reviews.feed.ReviewsFeedStoryMenuHelperProvider;
import javax.inject.Inject;

/* compiled from: UNFOLLOW */
public class ReviewsFeedEnvironment extends BaseFeedEnvironment {
    private final FeedListType f21535m;
    private final ReviewsFeedStoryMenuHelper f21536n;
    public final ReviewStoriesFeedController f21537o;

    @Inject
    public ReviewsFeedEnvironment(ReviewsFeedStoryMenuHelperProvider reviewsFeedStoryMenuHelperProvider, @Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted ReviewStoriesFeedController reviewStoriesFeedController) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f21536n = reviewsFeedStoryMenuHelperProvider.m25140a(this);
        this.f21535m = feedListType;
        this.f21537o = reviewStoriesFeedController;
    }

    public final FeedListType m25104c() {
        return this.f21535m;
    }

    public final BaseFeedStoryMenuHelper m25105e() {
        return this.f21536n;
    }
}
