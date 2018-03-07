package com.facebook.video.player.plugins;

import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: composerPhotoConfigurationFromDraft */
/* synthetic */ class SubtitlePlugin$2 {
    static final /* synthetic */ int[] f19381a = new int[State.values().length];

    static {
        try {
            f19381a[State.PLAYING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19381a[State.PLAYBACK_COMPLETE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19381a[State.ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
