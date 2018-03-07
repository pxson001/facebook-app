package com.facebook.messaging.audio.playback;

import android.media.MediaPlayer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import javax.inject.Inject;

/* compiled from: org.whispersystems.curve25519. */
public class AudioPlaybackTimer {
    public final Clock f8062a;
    private AbstractFbErrorReporter f8063b;
    public MediaPlayer f8064c;
    public long f8065d;
    public int f8066e;
    public int f8067f;

    @Inject
    public AudioPlaybackTimer(Clock clock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8062a = clock;
        this.f8063b = abstractFbErrorReporter;
    }

    public final int m8328a() {
        try {
            if (!this.f8064c.isPlaying()) {
                return this.f8067f;
            }
            int currentPosition = this.f8064c.getCurrentPosition();
            if (currentPosition <= 0) {
                currentPosition = 0;
            }
            if (currentPosition > this.f8067f) {
                this.f8066e = currentPosition;
                this.f8065d = this.f8062a.a();
                this.f8067f = this.f8066e;
                return currentPosition;
            }
            currentPosition = ((int) (this.f8062a.a() - this.f8065d)) + this.f8066e;
            if (currentPosition > this.f8064c.getDuration()) {
                return this.f8064c.getDuration();
            }
            this.f8067f = currentPosition;
            return currentPosition;
        } catch (Throwable e) {
            this.f8063b.a(SoftError.a(getClass().getSimpleName(), "last projected position: " + this.f8067f).a(e).g());
            return this.f8067f;
        }
    }
}
