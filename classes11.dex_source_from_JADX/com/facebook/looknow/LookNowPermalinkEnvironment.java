package com.facebook.looknow;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: via_nearby_result */
public class LookNowPermalinkEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final FeedListType f248m;

    @Inject
    public LookNowPermalinkEnvironment(Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f248m = feedListType;
    }

    public final FeedListType m277c() {
        return this.f248m;
    }

    public final BaseFeedStoryMenuHelper m278e() {
        return null;
    }
}
