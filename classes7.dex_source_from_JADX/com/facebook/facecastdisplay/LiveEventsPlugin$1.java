package com.facebook.facecastdisplay;

import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent.State;

/* compiled from: story_attachments_icon_image */
/* synthetic */ class LiveEventsPlugin$1 {
    static final /* synthetic */ int[] f2964a = new int[State.values().length];
    static final /* synthetic */ int[] f2965b = new int[RVPCommercialBreakStateChangeEvent.State.values().length];

    static {
        try {
            f2965b[RVPCommercialBreakStateChangeEvent.State.LIVE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2965b[RVPCommercialBreakStateChangeEvent.State.TRANSITION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2965b[RVPCommercialBreakStateChangeEvent.State.WAIT_FOR_ADS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2965b[RVPCommercialBreakStateChangeEvent.State.STATIC_COUNTDOWN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2965b[RVPCommercialBreakStateChangeEvent.State.VIDEO_AD.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2964a[State.FADE_IN.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f2964a[State.FADE_OUT.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
    }
}
