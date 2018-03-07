package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: media_tray_nux_exposure_count */
public abstract class StatefulRunnable<T> implements Runnable {
    protected final AtomicInteger f14526a = new AtomicInteger(0);

    protected abstract T mo2798c();

    public final void run() {
        if (this.f14526a.compareAndSet(0, 1)) {
            try {
                Object c = mo2798c();
                this.f14526a.set(3);
                try {
                    mo2796a(c);
                } finally {
                    mo2797b(c);
                }
            } catch (Exception e) {
                this.f14526a.set(4);
                mo2799a(e);
            }
        }
    }

    public final void m20939a() {
        if (this.f14526a.compareAndSet(0, 2)) {
            mo2800b();
        }
    }

    protected void mo2796a(T t) {
    }

    protected void mo2799a(Exception exception) {
    }

    protected void mo2800b() {
    }

    protected void mo2797b(T t) {
    }
}
