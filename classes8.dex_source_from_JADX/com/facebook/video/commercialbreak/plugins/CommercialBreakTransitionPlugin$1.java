package com.facebook.video.commercialbreak.plugins;

import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;

/* compiled from: location_title */
/* synthetic */ class CommercialBreakTransitionPlugin$1 {
    static final /* synthetic */ int[] f9756a = new int[State.values().length];

    static {
        try {
            f9756a[State.TRANSITION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9756a[State.WAIT_FOR_ADS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9756a[State.STATIC_COUNTDOWN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9756a[State.LIVE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f9756a[State.VIDEO_AD.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
