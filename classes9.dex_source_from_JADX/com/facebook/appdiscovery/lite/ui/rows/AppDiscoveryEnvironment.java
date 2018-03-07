package com.facebook.appdiscovery.lite.ui.rows;

import android.content.Context;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: selfie_cam */
public class AppDiscoveryEnvironment extends BaseFeedEnvironment {
    private final FeedListType f4143m;

    @Inject
    public AppDiscoveryEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f4143m = feedListType;
    }

    public final BaseFeedStoryMenuHelper m4202e() {
        return null;
    }

    public final FeedListType m4201c() {
        return this.f4143m;
    }
}
