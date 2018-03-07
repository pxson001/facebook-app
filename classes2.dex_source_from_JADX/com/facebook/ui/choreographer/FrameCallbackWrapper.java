package com.facebook.ui.choreographer;

import android.annotation.TargetApi;
import android.view.Choreographer.FrameCallback;

/* compiled from: response_format */
public abstract class FrameCallbackWrapper {
    private Runnable f6970a;
    private FrameCallback f6971b;

    /* compiled from: response_format */
    class C03481 implements FrameCallback {
        final /* synthetic */ FrameCallbackWrapper f8067a;

        C03481(FrameCallbackWrapper frameCallbackWrapper) {
            this.f8067a = frameCallbackWrapper;
        }

        public void doFrame(long j) {
            this.f8067a.mo1639a(j);
        }
    }

    public abstract void mo1639a(long j);

    @TargetApi(16)
    final FrameCallback m11565a() {
        if (this.f6971b == null) {
            this.f6971b = new C03481(this);
        }
        return this.f6971b;
    }

    final Runnable m11567b() {
        if (this.f6970a == null) {
            this.f6970a = new 2(this);
        }
        return this.f6970a;
    }
}
