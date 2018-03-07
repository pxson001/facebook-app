package com.facebook.video.videohome.environment;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoPlayerView;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedDimmingController;
import javax.annotation.Nullable;

/* compiled from: startRecording */
public class VideoHomeStoryPersistentState implements VideoStoryPersistentState {
    public AutoplayStateManager f2887a;
    private int f2888b;
    public ChannelFeedDimmingController f2889c;
    public VideoViewController f2890d;
    public boolean f2891e;
    public VideoPlayerView f2892f;

    @Nullable
    public final AutoplayStateManager m2794b() {
        return this.f2887a;
    }

    public final void m2793a(int i) {
        this.f2888b = i;
    }

    public final int m2792a() {
        return this.f2888b;
    }

    public final EventTriggerType m2795c() {
        return EventTriggerType.BY_USER;
    }
}
