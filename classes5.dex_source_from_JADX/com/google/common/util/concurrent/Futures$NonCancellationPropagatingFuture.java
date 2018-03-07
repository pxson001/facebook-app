package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture.TrustedFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;

@GwtIncompatible("TODO")
/* compiled from: bug_git_branch */
final class Futures$NonCancellationPropagatingFuture<V> extends TrustedFuture<V> {
    Futures$NonCancellationPropagatingFuture(final ListenableFuture<V> listenableFuture) {
        listenableFuture.a(new Runnable(this) {
            final /* synthetic */ Futures$NonCancellationPropagatingFuture f7659b;

            public void run() {
                this.f7659b.a(listenableFuture);
            }
        }, DirectExecutor.INSTANCE);
    }
}
