package com.facebook.video.player.plugins;

import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;

/* compiled from: composer_attach_photo_ready */
/* synthetic */ class CommercialBreakVideoPlugin$1 {
    static final /* synthetic */ int[] f19313a = new int[State.values().length];

    static {
        try {
            f19313a[State.LIVE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19313a[State.TRANSITION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19313a[State.WAIT_FOR_ADS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f19313a[State.STATIC_COUNTDOWN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f19313a[State.VIDEO_AD.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
