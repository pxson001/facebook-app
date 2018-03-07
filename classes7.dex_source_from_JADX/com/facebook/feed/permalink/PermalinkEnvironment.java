package com.facebook.feed.permalink;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelperFactory;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: album_artwork_url */
public class PermalinkEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final BaseFeedStoryMenuHelper f19569m;
    private final FeedListType f19570n;

    @Inject
    public PermalinkEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Delegate delegate, @Assisted BaseFeedStoryMenuHelperFactory baseFeedStoryMenuHelperFactory, @Assisted Runnable runnable) {
        super(context, runnable, delegate);
        this.f19569m = baseFeedStoryMenuHelperFactory.a(this);
        this.f19570n = feedListType;
    }

    public final BaseFeedStoryMenuHelper m22880e() {
        return this.f19569m;
    }

    public final FeedListType m22879c() {
        return this.f19570n;
    }
}
