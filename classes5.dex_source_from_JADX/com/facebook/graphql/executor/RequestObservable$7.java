package com.facebook.graphql.executor;

import com.google.common.base.Function;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/* compiled from: legal_disclaimer_text */
public final class RequestObservable$7 implements OnSubscribe<T> {
    final /* synthetic */ Function f3237a;

    public RequestObservable$7(Function function) {
        this.f3237a = function;
    }

    public final void m6291a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        this.f3237a.apply(new RequestSubscriber<T>(this) {
            final /* synthetic */ RequestObservable$7 f3236b;

            public final void m6288a() {
                subscriber.N_();
            }

            public final void m6290a(Throwable th) {
                subscriber.a(th);
            }

            public final void m6289a(T t) {
                subscriber.a(t);
            }
        });
    }
}
