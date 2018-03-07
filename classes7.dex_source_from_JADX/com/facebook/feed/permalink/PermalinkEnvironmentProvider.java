package com.facebook.feed.permalink;

import android.content.Context;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelperFactory;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: aid */
public class PermalinkEnvironmentProvider extends AbstractAssistedProvider<PermalinkEnvironment> {
    public static PermalinkEnvironment m22881a(Context context, FeedListType feedListType, Delegate delegate, BaseFeedStoryMenuHelperFactory baseFeedStoryMenuHelperFactory, Runnable runnable) {
        return new PermalinkEnvironment(context, feedListType, delegate, baseFeedStoryMenuHelperFactory, runnable);
    }
}
