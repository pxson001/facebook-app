package com.facebook.search.results.environment.videos;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import javax.annotation.Nullable;

/* compiled from: SYSTEM_LOADING */
public class SearchResultsVideoStoryPersistentState implements VideoStoryPersistentState {
    public final String f22720a;
    private final AutoplayStateManager f22721b;
    public VideoViewController f22722c;
    private int f22723d;

    public SearchResultsVideoStoryPersistentState(String str, AutoplayStateManager autoplayStateManager) {
        this.f22720a = str;
        this.f22721b = autoplayStateManager;
    }

    public final void m26273a(int i) {
        this.f22723d = i;
    }

    public final int m26272a() {
        return this.f22723d;
    }

    @Nullable
    public final AutoplayStateManager m26274b() {
        return this.f22721b;
    }

    public final EventTriggerType m26275c() {
        return EventTriggerType.BY_USER;
    }
}
