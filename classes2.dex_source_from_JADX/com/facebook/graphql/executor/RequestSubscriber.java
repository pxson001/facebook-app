package com.facebook.graphql.executor;

import rx.Subscriber;

/* compiled from: rtc_force_disable_software_agc */
public abstract class RequestSubscriber<T> implements RequestObserver<T> {
    public final Subscriber<T> f6462a = new C02891(this);

    /* compiled from: rtc_force_disable_software_agc */
    class C02891 extends Subscriber<T> {
        final /* synthetic */ RequestSubscriber f6463a;

        C02891(RequestSubscriber requestSubscriber) {
            this.f6463a = requestSubscriber;
        }

        public final void N_() {
            this.f6463a.mo1594a();
        }

        public final void mo1599a(Throwable th) {
            this.f6463a.mo1596a(th);
        }

        public final void mo1598a(T t) {
            this.f6463a.mo1595a((Object) t);
        }
    }

    public final boolean m11192b() {
        return this.f6462a.mo1601c();
    }

    public final void m11193c() {
        this.f6462a.mo1600b();
    }
}
