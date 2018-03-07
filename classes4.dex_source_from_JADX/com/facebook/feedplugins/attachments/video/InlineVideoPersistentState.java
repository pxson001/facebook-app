package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import javax.annotation.Nullable;

/* compiled from: photo_quality_for_thread */
public class InlineVideoPersistentState implements VideoStoryPersistentState {
    public boolean f4907a;
    private int f4908b;
    public VideoViewController f4909c;
    public boolean f4910d;
    public EventTriggerType f4911e = EventTriggerType.UNSET;
    public AutoplayStateManager f4912f;
    public VideoAutoplayTransitionManager f4913g;

    public final boolean m5301e() {
        return this.f4907a;
    }

    public final int mo420a() {
        return this.f4908b;
    }

    public final void mo421a(int i) {
        this.f4908b = i;
    }

    public final boolean m5302g() {
        return this.f4910d;
    }

    public final EventTriggerType mo423c() {
        return this.f4911e;
    }

    @Nullable
    public final AutoplayStateManager mo422b() {
        return this.f4912f;
    }
}
