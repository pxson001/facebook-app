package com.facebook.livephotos.exoplayer;

/* compiled from: param_media_iten_identifier */
public final class ExoPlaybackException extends Exception {
    public final boolean caughtAtTopLevel;

    public ExoPlaybackException(String str) {
        super(str);
        this.caughtAtTopLevel = false;
    }

    public ExoPlaybackException(Throwable th) {
        super(th);
        this.caughtAtTopLevel = false;
    }

    ExoPlaybackException(Throwable th, boolean z) {
        super(th);
        this.caughtAtTopLevel = z;
    }
}
