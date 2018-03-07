package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedFullscreenPlayer.FullscreenPlayerEnvironment;
import com.facebook.video.player.environment.CanPlayNextAndPreviousVideo;
import com.facebook.video.player.events.RVPFlingEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;

@DoNotStrip
/* compiled from: sub_cs */
public class AdvancePlaybackOnFlingPlugin extends RichVideoPlayerPluginWithEnv<CanPlayNextAndPreviousVideo> {

    /* compiled from: sub_cs */
    public class C02471 extends RichVideoPlayerEventSubscriber<RVPFlingEvent> {
        final /* synthetic */ AdvancePlaybackOnFlingPlugin f2713a;

        public C02471(AdvancePlaybackOnFlingPlugin advancePlaybackOnFlingPlugin) {
            this.f2713a = advancePlaybackOnFlingPlugin;
        }

        public final void m2601b(FbEvent fbEvent) {
            RVPFlingEvent rVPFlingEvent = (RVPFlingEvent) fbEvent;
            if (this.f2713a.c != null) {
                float x = rVPFlingEvent.b.getX();
                float y = rVPFlingEvent.b.getY();
                float x2 = rVPFlingEvent.a.getX();
                if ((Math.abs((x - x2) / (y - rVPFlingEvent.a.getY())) >= 1.0f ? 1 : null) != null) {
                    FullscreenPlayerEnvironment fullscreenPlayerEnvironment = (FullscreenPlayerEnvironment) this.f2713a.c;
                    Object obj = 1;
                    Object obj2 = x - x2 < 0.0f ? 1 : null;
                    if (x - x2 <= 0.0f) {
                        obj = null;
                    }
                    if (obj2 != null && fullscreenPlayerEnvironment.m2224c()) {
                        fullscreenPlayerEnvironment.m2221b(EventTriggerType.BY_USER);
                    } else if (obj != null && fullscreenPlayerEnvironment.m2225d()) {
                        fullscreenPlayerEnvironment.m2223c(EventTriggerType.BY_USER);
                    }
                }
            }
        }

        public final Class<RVPFlingEvent> m2600a() {
            return RVPFlingEvent.class;
        }
    }

    @DoNotStrip
    public AdvancePlaybackOnFlingPlugin(Context context) {
        this(context, null, 0);
    }

    private AdvancePlaybackOnFlingPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f.add(new C02471(this));
    }
}
