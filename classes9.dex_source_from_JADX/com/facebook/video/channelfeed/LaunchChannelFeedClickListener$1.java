package com.facebook.video.channelfeed;

import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: success_update_dropoff_location */
public class LaunchChannelFeedClickListener$1 extends C0241x1a4d85a1 {
    final /* synthetic */ LaunchChannelFeedClickListener f2620a;

    public LaunchChannelFeedClickListener$1(LaunchChannelFeedClickListener launchChannelFeedClickListener, FullscreenTransitionListener fullscreenTransitionListener) {
        this.f2620a = launchChannelFeedClickListener;
        super(fullscreenTransitionListener);
    }

    protected final void mo77a() {
        this.f2620a.b.b(EventTriggerType.BY_USER);
    }
}
