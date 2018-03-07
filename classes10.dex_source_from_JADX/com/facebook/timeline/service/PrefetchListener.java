package com.facebook.timeline.service;

/* compiled from: extra_redirect_to_messenger */
public class PrefetchListener<T> {
    private final PrefetchFinishListener<T> f12651a;
    public final T f12652b;
    private int f12653c = 0;
    private boolean f12654d = false;

    public PrefetchListener(PrefetchFinishListener<T> prefetchFinishListener, T t) {
        this.f12651a = prefetchFinishListener;
        this.f12652b = t;
    }

    public final void m12599c() {
        this.f12654d = true;
        m12596e();
    }

    public final void m12597a() {
        this.f12653c++;
    }

    public final void m12598b() {
        this.f12653c--;
        m12596e();
    }

    private void m12596e() {
        if (this.f12654d && this.f12653c == 0) {
            this.f12651a.m12600a(this.f12652b);
        }
    }
}
