package com.facebook.timeline.header.profilevideo;

import com.facebook.caspian.ui.standardheader.ProfileVideoView;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.timeline.header.TimelineHeaderTopAdapter.Part;
import com.facebook.timeline.header.ui.CaspianTimelineStandardHeader;
import com.facebook.timeline.listview.TimelineAdapter;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;

/* compiled from: fetch_actor_info */
public class TimelineProfileVideoViewportListener extends BaseViewportEventListener {
    public final void m11980a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
        if (i2 <= 0 && obj == Part.COVER_PHOTO) {
            CaspianTimelineStandardHeader e = ((TimelineAdapter) scrollingViewProxy.o()).f12030c.m11451e();
            if (e != null && e.m12024g()) {
                ProfileVideoView profileVideoView = e.getProfileVideoView();
                if (profileVideoView != null) {
                    profileVideoView.a(EventTriggerType.BY_AUTOPLAY);
                }
            }
        }
    }

    public final void m11981b(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i) {
        if (i <= 0 && obj == Part.COVER_PHOTO) {
            CaspianTimelineStandardHeader e = ((TimelineAdapter) scrollingViewProxy.o()).f12030c.m11451e();
            if (e != null) {
                ProfileVideoView profileVideoView = e.getProfileVideoView();
                if (profileVideoView != null) {
                    profileVideoView.b(EventTriggerType.BY_AUTOPLAY);
                }
            }
        }
    }
}
