package com.facebook.gametime.ui.plays;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: Starting fetch */
public class GametimePlaysEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final FeedListType f25316m;

    @Inject
    public GametimePlaysEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, @Assisted Delegate delegate) {
        super(context, runnable, delegate);
        this.f25316m = feedListType;
    }

    public final BaseFeedStoryMenuHelper m27222e() {
        return null;
    }

    public final FeedListType m27221c() {
        return this.f25316m;
    }
}
