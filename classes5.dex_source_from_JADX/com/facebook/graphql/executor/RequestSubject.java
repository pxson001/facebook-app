package com.facebook.graphql.executor;

import rx.subjects.ReplaySubject;

/* compiled from: legal_content */
public class RequestSubject<T> extends RequestObservable<T> implements RequestObserver<T> {
    public final ReplaySubject<T> f3238a;

    public RequestSubject(ReplaySubject<T> replaySubject) {
        super(replaySubject);
        this.f3238a = replaySubject;
    }

    public static <T> RequestSubject<T> m6293a(int i) {
        return new RequestSubject(ReplaySubject.a(i));
    }

    public final void m6294a() {
        this.f3238a.N_();
    }

    public final void m6296a(Throwable th) {
        this.f3238a.a(th);
    }

    public final void m6295a(T t) {
        this.f3238a.a(t);
    }
}
