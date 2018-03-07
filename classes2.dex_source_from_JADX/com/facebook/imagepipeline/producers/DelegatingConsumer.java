package com.facebook.imagepipeline.producers;

/* compiled from: mediaPostFromThirdParty */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {
    public final Consumer<O> f14615a;

    public DelegatingConsumer(Consumer<O> consumer) {
        this.f14615a = consumer;
    }

    public final Consumer<O> m21033d() {
        return this.f14615a;
    }

    protected void mo2790b(Throwable th) {
        this.f14615a.m20907a(th);
    }

    protected void mo2791c() {
        this.f14615a.m20908b();
    }

    protected final void mo2789b(float f) {
        this.f14615a.m20905a(f);
    }
}
