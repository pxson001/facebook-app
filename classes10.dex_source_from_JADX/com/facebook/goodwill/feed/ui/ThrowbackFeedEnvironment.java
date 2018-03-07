package com.facebook.goodwill.feed.ui;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: VISIT */
public class ThrowbackFeedEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final FeedListType f21176m;
    private final ThrowbackFeedMenuProvider f21177n;

    @Inject
    public ThrowbackFeedEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted Delegate delegate, ThrowbackFeedMenuProvider throwbackFeedMenuProvider) {
        super(context, runnable, delegate);
        this.f21176m = feedListType;
        this.f21177n = throwbackFeedMenuProvider;
    }

    public final BaseFeedStoryMenuHelper m22116e() {
        return this.f21177n.f21226a.m22168a(this);
    }

    public final FeedListType m22115c() {
        return this.f21176m;
    }
}
