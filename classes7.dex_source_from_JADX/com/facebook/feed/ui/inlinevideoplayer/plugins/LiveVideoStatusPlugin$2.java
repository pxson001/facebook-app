package com.facebook.feed.ui.inlinevideoplayer.plugins;

import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: The ViewPager center page can't be < 0 */
/* synthetic */ class LiveVideoStatusPlugin$2 {
    static final /* synthetic */ int[] f22267a = new int[State.values().length];
    static final /* synthetic */ int[] f22268b = new int[RVPCommercialBreakStateChangeEvent.State.values().length];

    static {
        try {
            f22268b[RVPCommercialBreakStateChangeEvent.State.LIVE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f22268b[RVPCommercialBreakStateChangeEvent.State.TRANSITION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f22268b[RVPCommercialBreakStateChangeEvent.State.WAIT_FOR_ADS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f22268b[RVPCommercialBreakStateChangeEvent.State.STATIC_COUNTDOWN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f22268b[RVPCommercialBreakStateChangeEvent.State.VIDEO_AD.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f22267a[State.PLAYBACK_COMPLETE.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f22267a[State.PLAYING.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
    }
}
