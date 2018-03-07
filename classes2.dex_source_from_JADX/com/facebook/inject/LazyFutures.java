package com.facebook.inject;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: method/user.resetPasswordPreconfirmation */
public class LazyFutures {

    /* compiled from: method/user.resetPasswordPreconfirmation */
    final class C05422 extends LazyFuture<T> {
        final /* synthetic */ Lazy f13549a;
        final /* synthetic */ Function f13550b;
        final /* synthetic */ Executor f13551c;

        C05422(Lazy lazy, Function function, Executor executor) {
            this.f13549a = lazy;
            this.f13550b = function;
            this.f13551c = executor;
        }

        protected final ListenableFuture<T> mo2649a() {
            return Futures.m2450a((ListenableFuture) this.f13549a.get(), this.f13550b, this.f13551c);
        }
    }

    /* compiled from: method/user.resetPasswordPreconfirmation */
    final class C05441 implements Lazy<ListenableFuture<T>> {
        final /* synthetic */ ListenableFuture f13559a;

        C05441(ListenableFuture listenableFuture) {
            this.f13559a = listenableFuture;
        }

        public final Object get() {
            return this.f13559a;
        }
    }

    public static <T> Lazy<ListenableFuture<T>> m19932a(ListenableFuture<T> listenableFuture) {
        return new C05441(listenableFuture);
    }

    public static <T, E> Lazy<ListenableFuture<T>> m19931a(Lazy<? extends ListenableFuture<E>> lazy, Function<E, T> function, Executor executor) {
        return new C05422(lazy, function, executor);
    }

    public static ListBuilder m19933a() {
        return new ListBuilder();
    }
}
