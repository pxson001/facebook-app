package com.facebook.camera.utils;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;

/* compiled from: all_scheduled_posts */
public abstract class PhotoCapture {
    static final Class<?> f11001b = CameraActivity.class;
    private final AbstractFbErrorReporter f11002a;
    public CaptureState f11003c = CaptureState.READY;

    /* compiled from: all_scheduled_posts */
    /* synthetic */ class C10711 {
        static final /* synthetic */ int[] f11059a = new int[CaptureState.values().length];

        static {
            try {
                f11059a[CaptureState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11059a[CaptureState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: all_scheduled_posts */
    public enum CaptureState {
        READY,
        QUEUED,
        CAPTURE_PENDING
    }

    protected abstract void mo1160a(CaptureState captureState);

    public PhotoCapture(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11002a = abstractFbErrorReporter;
    }

    private void m18994b(CaptureState captureState) {
        CaptureState captureState2 = this.f11003c;
        this.f11003c = captureState;
        CaptureState captureState3 = this.f11003c;
        if (captureState2 != captureState3) {
            mo1160a(captureState3);
        }
    }

    public final boolean m18997c() {
        CaptureState captureState = this.f11003c;
        return captureState == CaptureState.READY || captureState == CaptureState.QUEUED;
    }

    public final void m19000f() {
        if (this.f11003c != CaptureState.CAPTURE_PENDING) {
            this.f11002a.b(f11001b.getSimpleName(), "shutterAnimationComplete while " + this.f11003c);
        }
        m18994b(CaptureState.READY);
    }

    public final void m18996b() {
        this.f11003c = CaptureState.READY;
        mo1160a(this.f11003c);
    }

    public final void m18998d() {
        switch (C10711.f11059a[this.f11003c.ordinal()]) {
            case 1:
                m18994b(CaptureState.QUEUED);
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                new StringBuilder("queueCapture while ").append(this.f11003c);
                return;
            default:
                this.f11002a.b(f11001b.getSimpleName(), "queueCapture while " + this.f11003c);
                return;
        }
    }

    public final void m18999e() {
        if (!m18997c()) {
            this.f11002a.b(f11001b.getSimpleName(), "captureStarted while " + this.f11003c);
        }
        m18994b(CaptureState.CAPTURE_PENDING);
    }
}
