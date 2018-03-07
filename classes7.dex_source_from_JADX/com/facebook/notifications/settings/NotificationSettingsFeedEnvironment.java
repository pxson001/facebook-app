package com.facebook.notifications.settings;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_carrier */
public class NotificationSettingsFeedEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    public final FeedListType m10687c() {
        return NotificationSettingsFeedListType.f8722a;
    }

    @Inject
    public NotificationSettingsFeedEnvironment(@Assisted Context context, @Assisted Delegate delegate, @Assisted Runnable runnable) {
        super(context, runnable, delegate);
    }

    @Nullable
    public final BaseFeedStoryMenuHelper m10688e() {
        return null;
    }
}
