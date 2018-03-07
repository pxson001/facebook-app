package com.facebook.video.engine.logverifier;

import com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier.BasicVideoState;

/* compiled from: composer_text_pasted */
/* synthetic */ class VideoLoggingStateMachineVerifier$1 {
    static final /* synthetic */ int[] f18844a = new int[BasicVideoState.values().length];

    static {
        try {
            f18844a[BasicVideoState.REQUESTED_PLAY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f18844a[BasicVideoState.PLAYING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f18844a[BasicVideoState.PAUSED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f18844a[BasicVideoState.SEEKING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f18844a[BasicVideoState.ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
