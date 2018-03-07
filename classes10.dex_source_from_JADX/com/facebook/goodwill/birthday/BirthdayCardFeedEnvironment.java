package com.facebook.goodwill.birthday;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: WHATEVER */
public class BirthdayCardFeedEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final FeedListType f21002m;

    @Inject
    public BirthdayCardFeedEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Delegate delegate, @Assisted Runnable runnable) {
        super(context, runnable, delegate);
        this.f21002m = feedListType;
    }

    public final BaseFeedStoryMenuHelper m21994e() {
        return null;
    }

    public final FeedListType m21993c() {
        return this.f21002m;
    }
}
