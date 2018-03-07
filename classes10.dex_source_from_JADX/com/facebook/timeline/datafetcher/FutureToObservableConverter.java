package com.facebook.timeline.datafetcher;

import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestSubject;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import rx.subjects.ReplaySubject;

/* compiled from: group_commerce_product_item_id */
public class FutureToObservableConverter {

    /* compiled from: group_commerce_product_item_id */
    final class C15281 implements FutureCallback<T> {
        final /* synthetic */ RequestSubject f10415a;

        C15281(RequestSubject requestSubject) {
            this.f10415a = requestSubject;
        }

        public final void onSuccess(@Nullable T t) {
            this.f10415a.a(t);
            this.f10415a.a();
        }

        public final void onFailure(Throwable th) {
            this.f10415a.a(th);
        }
    }

    public static <T> RequestObservable<T> m10531a(ListenableFuture<T> listenableFuture) {
        RequestSubject requestSubject = new RequestSubject(ReplaySubject.d());
        Futures.a(listenableFuture, new C15281(requestSubject), MoreExecutors.a());
        return new RequestObservable(requestSubject.a.b());
    }
}
