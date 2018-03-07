package com.facebook.timeline.viewfeaturedcontainers.ui;

import android.content.Context;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.player.FbVideoView;

/* compiled from: extra_event_start_time */
public class FeaturedVideoView extends FbVideoView {
    public FeaturedVideoView(Context context) {
        super(context);
        setShouldCropToFit(true);
        this.s = false;
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.PROFILE_FEATURED_CONTAINER_VIDEO;
    }

    public final void m12890f() {
        super.f();
        a(EventTriggerType.BY_PLAYER);
    }
}
