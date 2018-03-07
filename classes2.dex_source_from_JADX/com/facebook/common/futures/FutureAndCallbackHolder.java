package com.facebook.common.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: messenger_emoji_likes_with_history */
public class FutureAndCallbackHolder<T> {
    public final ListenableFuture<T> f14025a;
    public final DisposableFutureCallback<T> f14026b;

    public FutureAndCallbackHolder(ListenableFuture<T> listenableFuture, DisposableFutureCallback<T> disposableFutureCallback) {
        this.f14025a = listenableFuture;
        this.f14026b = disposableFutureCallback;
    }

    public static <T> FutureAndCallbackHolder<T> m20344a(ListenableFuture<T> listenableFuture, DisposableFutureCallback<T> disposableFutureCallback) {
        return new FutureAndCallbackHolder(listenableFuture, disposableFutureCallback);
    }

    public final ListenableFuture<T> m20345a() {
        return this.f14025a;
    }

    public final DisposableFutureCallback<T> m20347b() {
        return this.f14026b;
    }

    public final void m20346a(boolean z) {
        this.f14026b.jc_();
        this.f14025a.cancel(z);
    }
}
