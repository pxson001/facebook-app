package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: Timed out waiting for result */
public class FullscreenFeedbackWithCountPlugin extends FeedbackWithCountPlugin {
    private final View f22125r;

    /* compiled from: Timed out waiting for result */
    class OrientationChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOrientationChangedEvent> {
        final /* synthetic */ FullscreenFeedbackWithCountPlugin f22124a;

        public OrientationChangedEventSubscriber(FullscreenFeedbackWithCountPlugin fullscreenFeedbackWithCountPlugin) {
            this.f22124a = fullscreenFeedbackWithCountPlugin;
        }

        public final void m24750b(FbEvent fbEvent) {
            FullscreenFeedbackWithCountPlugin.m24752c(this.f22124a, ((RVPOrientationChangedEvent) fbEvent).a);
        }

        public final Class<RVPOrientationChangedEvent> m24749a() {
            return RVPOrientationChangedEvent.class;
        }
    }

    public FullscreenFeedbackWithCountPlugin(Context context) {
        this(context, null);
    }

    public FullscreenFeedbackWithCountPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullscreenFeedbackWithCountPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22125r = a(2131562069);
        this.f.add(new OrientationChangedEventSubscriber(this));
    }

    protected final void mo1540a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.mo1540a(richVideoPlayerParams, z);
        if (z) {
            m24752c(this, getResources().getConfiguration().orientation);
        }
    }

    public static void m24752c(FullscreenFeedbackWithCountPlugin fullscreenFeedbackWithCountPlugin, int i) {
        if (i == 2) {
            fullscreenFeedbackWithCountPlugin.f22125r.setVisibility(8);
        } else {
            fullscreenFeedbackWithCountPlugin.f22125r.setVisibility(0);
        }
    }
}
