package com.facebook.graphql.executor;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/* compiled from: reranking_timeout_seconds */
public class RequestObservable<T> {
    public final Observable<T> f7196a;

    public RequestObservable(Observable<T> observable) {
        this.f7196a = observable;
    }

    public static <T> RequestObservable<T> m11645b() {
        return new RequestObservable(Observable.m11244b(Collections.emptyList()));
    }

    public final RequestSubscription m11649a(final RequestObserver<T> requestObserver) {
        return new RequestSubscription(this.f7196a.m11255b(new Subscriber<T>(this) {
            final /* synthetic */ RequestObservable f7200b;

            public final void N_() {
                requestObserver.mo1594a();
            }

            public final void mo1599a(Throwable th) {
                requestObserver.mo1596a(th);
            }

            public final void mo1598a(T t) {
                requestObserver.mo1595a((Object) t);
            }
        }));
    }

    public final RequestObservable<T> m11648a(Executor executor) {
        return new RequestObservable(this.f7196a.m11249a(Schedulers.a(executor)));
    }

    public final RequestObservable<T> m11652b(Executor executor) {
        return new RequestObservable(this.f7196a.m11253b(Schedulers.a(executor)));
    }

    public final <TOut> RequestObservable<TOut> m11647a(Function<T, TOut> function) {
        return new RequestObservable(this.f7196a.m11254b(new 2(this, function)));
    }

    public final RequestObservable<T> m11646a(RequestObservable<T> requestObservable) {
        return new RequestObservable(Observable.m11241a(this.f7196a, requestObservable.f7196a));
    }

    public final RequestObservable<T> m11650b(RequestObservable<T> requestObservable) {
        Observable observable = this.f7196a;
        Observable observable2 = requestObservable.f7196a;
        return new RequestObservable(Observable.m11246d(Observable.m11244b(Arrays.asList(new Object[]{observable, observable2}))));
    }

    public final RequestObservable<T> m11651b(Function<T, Boolean> function) {
        return new RequestObservable(this.f7196a.m11250a(new 3(this, function)));
    }

    public static <T> RequestObservable<T> m11641a(RequestObservable<T> requestObservable, RequestObservable<T> requestObservable2) {
        return new RequestObservable(Observable.m11241a(requestObservable.f7196a, requestObservable2.f7196a));
    }

    public static <T> RequestObservable<T> m11643a(RequestObservable<? extends T> requestObservable, RequestObservable<? extends T> requestObservable2, RequestObservable<? extends T> requestObservable3) {
        Observable observable = requestObservable.f7196a;
        Observable observable2 = requestObservable2.f7196a;
        Observable observable3 = requestObservable3.f7196a;
        return new RequestObservable(Observable.m11247e(Observable.m11244b(Arrays.asList(new Observable[]{observable, observable2, observable3}))));
    }

    public static <T> RequestObservable<T> m11644a(List<RequestObservable<T>> list) {
        return new RequestObservable(Observable.m11247e(Observable.m11244b(Iterables.m945a((Iterable) list, new 4()))));
    }

    public static <T1, T2, R> RequestObservable<R> m11642a(RequestObservable<? extends T1> requestObservable, RequestObservable<? extends T2> requestObservable2, ZipFunc2<? super T1, ? super T2, ? extends R> zipFunc2) {
        return new RequestObservable(Observable.m11242a(requestObservable.f7196a, requestObservable2.f7196a, new 5(zipFunc2)));
    }
}
