package com.facebook.feed.environment.impl;

import com.facebook.feed.analytics.AnalyticsHelper;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.Assisted;
import com.facebook.ufiservices.event.UfiEvents$PageLikeClickedEvent;
import javax.inject.Inject;

/* compiled from: new_place_creation */
public class CanLikePageImpl implements CanLikePage {
    private final FeedEventBus f12304a;
    private final HasFeedListType f12305b;

    @Inject
    public CanLikePageImpl(FeedEventBus feedEventBus, @Assisted HasFeedListType hasFeedListType) {
        this.f12304a = feedEventBus;
        this.f12305b = hasFeedListType;
    }

    public final void mo2430a(FeedProps feedProps, String str, String str2, String str3) {
        this.f12304a.mo651a(new UfiEvents$PageLikeClickedEvent(feedProps, str, str2, str3, AnalyticsHelper.m28995a(this.f12305b.mo2446c())));
    }
}
