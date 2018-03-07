package com.facebook.video.channelfeed;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoResolution;
import javax.annotation.Nullable;

/* compiled from: surge_estimate */
public class ChannelFeedStoryPersistentState implements VideoStoryPersistentState {
    public AutoplayStateManager f2499a;
    public ChannelFeedVideoController f2500b;
    public ChannelFeedDimmingController f2501c;
    private int f2502d;
    public boolean f2503e = false;
    public boolean f2504f = false;
    public boolean f2505g = false;
    public VideoResolution f2506h = VideoResolution.STANDARD_DEFINITION;
    public EventTriggerType f2507i = EventTriggerType.BY_AUTOPLAY;
    public boolean f2508j = false;

    public final void m2433a(int i) {
        this.f2502d = i;
    }

    public final int m2432a() {
        return this.f2502d;
    }

    @Nullable
    public final AutoplayStateManager m2434b() {
        return this.f2499a;
    }

    public final EventTriggerType m2435c() {
        return this.f2507i;
    }
}
