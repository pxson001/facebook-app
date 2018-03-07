package com.facebook.common.futures;

import com.facebook.common.futures.AlwaysSuccessfulReturnsThrowableFuture.C07691;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;

/* compiled from: isInitiallyForeground */
public final class FbFutures$3 implements Function<ListenableFuture<?>, ListenableFuture<Object>> {
    @Nullable
    public final Object apply(@Nullable Object obj) {
        ListenableFuture listenableFuture = (ListenableFuture) obj;
        if (listenableFuture == null) {
            return null;
        }
        AlwaysSuccessfulReturnsThrowableFuture alwaysSuccessfulReturnsThrowableFuture = new AlwaysSuccessfulReturnsThrowableFuture(listenableFuture);
        Futures.m2458a(listenableFuture, new C07691(alwaysSuccessfulReturnsThrowableFuture), MoreExecutors.m1813a());
        return alwaysSuccessfulReturnsThrowableFuture;
    }
}
