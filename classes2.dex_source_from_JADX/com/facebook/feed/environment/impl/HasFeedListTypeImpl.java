package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: new_payment_address_picker */
public class HasFeedListTypeImpl implements HasFeedListType {
    private final FeedListType f12307a;

    @Inject
    public HasFeedListTypeImpl(@Assisted FeedListType feedListType) {
        this.f12307a = feedListType;
    }

    public final FeedListType mo2446c() {
        return this.f12307a;
    }
}
