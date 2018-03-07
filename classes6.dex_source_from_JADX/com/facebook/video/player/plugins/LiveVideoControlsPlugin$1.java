package com.facebook.video.player.plugins;

import com.facebook.video.player.events.RVPLiveVideoControlChangeHideTimeEvent.Event;

/* compiled from: composer_add_location_failure */
/* synthetic */ class LiveVideoControlsPlugin$1 {
    static final /* synthetic */ int[] f19355a = new int[Event.values().length];

    static {
        try {
            f19355a[Event.STOP_HIDE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19355a[Event.REFRESH_HIDE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
