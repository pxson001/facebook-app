package com.facebook.video.commercialbreak.plugins;

import com.facebook.video.commercialbreak.CommercialBreakVideoAdFetcher$State;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.facebook.video.player.plugins.PlaybackController;

/* compiled from: location_trigger */
/* synthetic */ class CommercialBreakPlugin$2 {
    static final /* synthetic */ int[] f9751a = new int[State.values().length];
    static final /* synthetic */ int[] f9752b = new int[CommercialBreakVideoAdFetcher$State.values().length];
    static final /* synthetic */ int[] f9753c = new int[PlaybackController.State.values().length];

    static {
        try {
            f9753c[PlaybackController.State.PLAYING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9753c[PlaybackController.State.PLAYBACK_COMPLETE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9753c[PlaybackController.State.ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9752b[CommercialBreakVideoAdFetcher$State.FAILED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f9752b[CommercialBreakVideoAdFetcher$State.SUCCESS.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f9752b[CommercialBreakVideoAdFetcher$State.FETCHING.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f9752b[CommercialBreakVideoAdFetcher$State.IDLE.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f9751a[State.STATIC_COUNTDOWN.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f9751a[State.VIDEO_AD.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f9751a[State.TRANSITION.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f9751a[State.LIVE.ordinal()] = 4;
        } catch (NoSuchFieldError e11) {
        }
    }
}
