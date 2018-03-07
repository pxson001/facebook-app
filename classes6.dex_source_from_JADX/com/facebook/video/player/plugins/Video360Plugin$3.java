package com.facebook.video.player.plugins;

import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: communication_rank */
/* synthetic */ class Video360Plugin$3 {
    static final /* synthetic */ int[] f19405a = new int[State.values().length];

    static {
        try {
            f19405a[State.PLAYING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19405a[State.ATTEMPT_TO_PLAY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19405a[State.PAUSED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f19405a[State.PLAYBACK_COMPLETE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f19405a[State.ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f19405a[State.PREPARED.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
