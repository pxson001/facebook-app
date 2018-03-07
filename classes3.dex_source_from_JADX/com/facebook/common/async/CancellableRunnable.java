package com.facebook.common.async;

/* compiled from: Metadata is not complete. Ignoring. (%s) */
public class CancellableRunnable implements Runnable {
    private volatile Runnable f432a;

    public CancellableRunnable(Runnable runnable) {
        this.f432a = runnable;
    }

    public final void m409a() {
        this.f432a = null;
    }

    public void run() {
        Runnable runnable = this.f432a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
