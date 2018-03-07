package com.facebook.feed.rows.photosfeed.videos;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: _fail */
public class PhotosFeedInlineVideoPersistentState implements VideoStoryPersistentState {
    private int f20345a;
    public boolean f20346b = false;

    public final int m23468a() {
        return this.f20345a;
    }

    public final void m23469a(int i) {
        this.f20345a = i;
    }

    public final AutoplayStateManager m23470b() {
        return null;
    }

    public final EventTriggerType m23471c() {
        return EventTriggerType.BY_USER;
    }
}
